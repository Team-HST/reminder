package com.hst.reminder.authentication.infra;

import com.hst.reminder.authentication.domain.AuthenticationToken;
import com.hst.reminder.authentication.domain.AuthenticationTokenProvider;
import com.hst.reminder.configuration.AppProperties;
import com.hst.reminder.member.domain.MemberId;
import com.hst.reminder.utils.TimeUtils;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author dlgusrb0808@gmail.com
 */
@Component
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenProvider.class);

	private AppProperties appProperties;

	@Override
	public AuthenticationToken issue(MemberId tokenOwnerId) {
		return AuthenticationToken.builder()
				.tokenOwnerId(tokenOwnerId)
				.token(buildToken(tokenOwnerId.getValue()))
				.build();
	}

	// JWT 토큰 생성
	private String buildToken(Long memberId) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiryAt = now.plus(appProperties.getAuth().getTokenExpirationMs(), ChronoUnit.MILLIS);
		return Jwts.builder()
				.setSubject(String.valueOf(memberId))
				.setIssuedAt(TimeUtils.toDate(now))
				.setExpiration(TimeUtils.toDate(expiryAt))
				.signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
				.compact();
	}

	@Override
	public Long getTokenOwnerId(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(appProperties.getAuth().getTokenSecret())
				.parseClaimsJws(token)
				.getBody();

		return Long.parseLong(claims.getSubject());
	}

	@Override
	public boolean validateTokenValue(String token) {
		try {
			Jwts.parser()
				.setSigningKey(appProperties.getAuth().getTokenSecret())
				.parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature", e);
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token", e);
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token", e);
		} catch (UnsupportedJwtException e) {
			logger.error("Unsupported JWT token", e);
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty.", e);
		}
		return false;
	}

	@Override
	public void setAppProperties(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
}
