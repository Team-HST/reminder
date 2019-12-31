package com.hst.reminder.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class ErrorDescription {

	private int statusCode;
	private String message;

	/***
	 * 401 UNAUTHORIZED ErrorDescription 생성
	 * @param e 오류 원인
	 * @return Error
	 */
	public static ErrorDescription unauthorized(Exception e) {
		return create(HttpStatus.UNAUTHORIZED, e);
	}

	/***
	 * 500 INTERNAL_SERVER_ERROR ErrorDescription 생성
	 * @param e 오류 원인
	 * @return ErrorDescription
	 */
	public static ErrorDescription internalServerError(Exception e) {
		return create(HttpStatus.INTERNAL_SERVER_ERROR, e);
	}

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

}
