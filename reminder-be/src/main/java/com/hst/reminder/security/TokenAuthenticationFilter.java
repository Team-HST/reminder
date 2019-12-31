package com.hst.reminder.security;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.security.exception.InvalidTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private MemberService memberService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String token = getJwtFromRequest(request);
		if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
			Long memberId = tokenProvider.fetchMemberId(token);
			try {
				Member member = (Member) memberService.loadUserByUsername(memberId.toString());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member,
						member.getPassword(), member.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (UsernameNotFoundException e) {
				throw new InvalidTokenException("유효하지않은 인증토큰 입니다. 인증토큰 회원 정보 오류");
			}
		}

		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
