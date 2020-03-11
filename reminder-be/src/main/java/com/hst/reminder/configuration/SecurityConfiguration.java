package com.hst.reminder.configuration;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.oauth2.infra.HttpCookieOAuth2AuthorizationRequestRepository;
import com.hst.reminder.oauth2.infra.OAuth2AuthenticationSuccessHandler;
import com.hst.reminder.security.exception.ExceptionHandlerFilter;
import com.hst.reminder.security.exception.entrypoint.RestAuthenticationEntryPoint;
import com.hst.reminder.security.filter.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final String[] PUBLIC_URI = {
//			"/",
//			"/favicon.ico",
//			"/error",
//			"/docs/**",
//			"/sso/**",
//			"/oauth2/**"
			"/**"
	};

	@Autowired
	private MemberService memberService;

	@Autowired
	private OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.csrf()
				.disable()
			.formLogin()
				.disable()
			.httpBasic()
				.disable()
			.exceptionHandling()
				.authenticationEntryPoint(new RestAuthenticationEntryPoint())
				.and()
			.authorizeRequests()
				.antMatchers(PUBLIC_URI)
					.permitAll()
				.anyRequest()
					.authenticated()
					.and()
			.oauth2Login()
				// OAuth2 로그인 시작점 설정 (e.g. /sso/github, /sso/google)
				// authorizationRequestRepository 는 OAuth2 인증 성공 후 HTTP Request 에 인증정보 담을 방법을 결정
				// Spring 기본제공 구현체는 세션기반 HttpSessionOAuth2AuthorizationRequestRepository
				// REST API Service 를 위해 세션 STATELESS 설정하기 때문에, 쿠키 기반 커스텀 구현체를 사용함
				.authorizationEndpoint()
					.baseUri("/sso")
					.authorizationRequestRepository(cookieOAuthAuthorizationRequestRepository())
					.and()
				// OAuth2 인증이 완료된 후 처리할 Handler
				.successHandler(authenticationSuccessHandler)
				// .failureHandler() -> failureHandler 추가 고려
				// 시스템에서 제공할 OAuth2 클라이언트 등록 (이 코드에선 github)
				.clientRegistrationRepository(clientRegistrationRepository())
				.authorizedClientService(authorizedClientService());

		// Controller 도달 전 발생한 예외를 처리하기 위한 Filter
		http.addFilterBefore(exceptionHandlerFilter(), CorsFilter.class);

		// 토큰기반 인증을 위해 토큰검사를 수행하는 Filter 추가
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	public ExceptionHandlerFilter exceptionHandlerFilter() {
		return new ExceptionHandlerFilter();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public HttpCookieOAuth2AuthorizationRequestRepository cookieOAuthAuthorizationRequestRepository() {
		return new HttpCookieOAuth2AuthorizationRequestRepository();
	}

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(github());
	}

	public OAuth2AuthorizedClientService authorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}

	private ClientRegistration github() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github")
				.clientId("bd8b003f5fe25b1ba86e")
				.clientSecret("ecfde69bb487af3705b4eb316123c3acd72847e9")
				.build();
	}

}
