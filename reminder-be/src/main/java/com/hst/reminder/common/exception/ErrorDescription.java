package com.hst.reminder.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDescription {

	private int statusCode;
	private String message;
	private Map<String, String> fieldErrors;

	/***
	 * ErrorDescription 생성
	 * @param status HTTP 응답코드
	 * @param e 오류 원인
	 * @return ErrorDescription
	 */
	public static ErrorDescription create(HttpStatus status, Exception e) {
		return ErrorDescription.builder()
				.statusCode(status.value())
				.message(e.getLocalizedMessage())
				.build();
	}

	public static ErrorDescription create(HttpStatus status, BindingResult bindingResult) {
		return ErrorDescription.builder()
				.statusCode(status.value())
				.message(status.getReasonPhrase())
				.fieldErrors(bindingResult.getFieldErrors()
						.stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)))
				.build();
	}

}
