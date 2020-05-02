package com.hst.reminder.security.exception;

import com.hst.reminder.common.exception.ErrorDescription;
import com.hst.reminder.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ExceptionHandlerFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			LOGGER.error("Exception occur on filter", e);
			sendErrorResponse(e, response);
		}
	}

	private void sendErrorResponse(Exception e, HttpServletResponse response) throws IOException {
		if (e instanceof ResponseStatusException) {
			response.setStatus(((ResponseStatusException) e).getStatus().value());
		} else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.getWriter().write(JsonUtils.serialize(ErrorDescription.create(HttpStatus.UNAUTHORIZED, e)));
	}

}
