package com.hst.reminder.security;

import com.hst.reminder.configuration.AppProperties;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.utils.TimeUtils;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author dlgusrb0808@gmail.com
 */
@Component
public class TokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

	private final AppProperties appProperties;

	public TokenProvider(AppProperties appProperties) {
		this.appProperties = appProperties;
	}

	public String createToken(Authentication authentication) {
		Member member = (Member) authentication.getPrincipal();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiryAt = now.plus(appProperties.getAuth().getTokenExpirationMs(), ChronoUnit.MILLIS);

		return Jwts.builder()
				.setSubject(Long.toString(member.getId()))
				.setIssuedAt(TimeUtils.toDate(now))
				.setExpiration(TimeUtils.toDate(expiryAt))
				.signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
				.compact();
	}

	public Long fetchMemberId(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(appProperties.getAuth().getTokenSecret())
				.parseClaimsJws(token)
				.getBody();

		return Long.parseLong(claims.getSubject());
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty.");
		}
		return false;
	}

}
