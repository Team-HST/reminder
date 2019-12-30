package com.hst.reminder.security;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
			Member member = (Member) memberService.loadUserByUsername(memberId.toString());
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member,
					member.getPassword(), member.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
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
