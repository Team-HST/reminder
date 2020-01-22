package com.hst.reminder.oauth2.infra;

import com.hst.reminder.authentication.domain.AuthenticationToken;
import com.hst.reminder.authentication.domain.AuthenticationTokenProvider;
import com.hst.reminder.configuration.AppProperties;
import com.hst.reminder.configuration.aware.AppPropertiesAware;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static com.hst.reminder.oauth2.infra.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

/**
 * @author dlgusrb0808@gmail.com
 */
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AppPropertiesAware {

	private static final Logger logger = LoggerFactory.getLogger(OAuth2AuthenticationSuccessHandler.class);

	private AuthenticationTokenProvider authenticationTokenProvider;
	private HttpCookieOAuth2AuthorizationRequestRepository cookieOAuth2AuthorizationRequestRepository;
	private AppProperties appProperties;

	@Autowired
	public OAuth2AuthenticationSuccessHandler(AuthenticationTokenProvider authenticationTokenProvider,
											  HttpCookieOAuth2AuthorizationRequestRepository cookieOAuth2AuthorizationRequestRepository) {
		this.authenticationTokenProvider = authenticationTokenProvider;
		this.cookieOAuth2AuthorizationRequestRepository = cookieOAuth2AuthorizationRequestRepository;
		this.setDefaultTargetUrl("/oauth2/finalize-authorization");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(request, response, authentication);

		if (response.isCommitted()) {
			logger.info("Response has already been committed. Unable to redirect to {}", targetUrl);
			return;
		}
		logger.info("SSO Login finish. redirect to {}", targetUrl);
		clearAuthenticationAttributes(request, response);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) {
		Optional<String> redirectUri = checkUnauthorizedRedirectUrl(request);
		String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
		AuthenticationToken authenticationToken = authenticationTokenProvider.issue(((Member)authentication.getPrincipal()).getId());

		return UriComponentsBuilder.fromUriString(targetUrl)
				.queryParam("token", authenticationToken.getToken())
				.queryParam("memberId", authenticationToken.getTokenOwnerId())
				.build().toUriString();
	}

	// HTTP cookie 에 비인가 redirect url 이 포함되어있는지 검사
	private Optional<String> checkUnauthorizedRedirectUrl(HttpServletRequest request) {
		Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME).map(Cookie::getValue);
		if(redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
			throw new AccessDeniedException("Unauthorized Redirect URI and can't proceed with the authentication");
		}
		return redirectUri;
	}

	private boolean isAuthorizedRedirectUri(String uri) {
		URI clientRedirectUri = URI.create(uri);
		return appProperties.getOauth2().getAuthorizedRedirectUris()
				.stream()
				.anyMatch(authorizedRedirectUri -> {
					URI authorizedURI = URI.create(authorizedRedirectUri);
					return authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost()) &&
						   authorizedURI.getPort() == clientRedirectUri.getPort();
				});
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
		super.clearAuthenticationAttributes(request);
		cookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
	}

	@Override
	public void setAppProperties(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
}
