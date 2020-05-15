package com.hst.reminder.utils;

import com.hst.reminder.common.exception.ForbiddenException;
import com.hst.reminder.member.domain.Member;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.function.ToLongFunction;

/**
 * @author dlgusrb0808@gmail.com
 */
@UtilityClass
public class SecurityUtils {
	/***
	 * 현재 인증된 사용자 정보 반환
	 * @return 인증된 사용자
	 */
	public static Member currentUser() {
		return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	/***
	 * 자원에 권한이 있는지 검사
	 * @param resource 대상 자원
	 * @param ownerIdExtractor 자원 주인 식별자 추출 방식
	 * @param <T> 자원 타입
	 * @throws ForbiddenException 자원에 권한이 없는 경우
	 */
	public static <T> void authorizeResource(T resource, ToLongFunction<T> ownerIdExtractor) {
		Long resourceOwnerId = ownerIdExtractor.applyAsLong(resource);
		Member currentUser = currentUser();
		if (!resourceOwnerId.equals(currentUser.getId())) {
			throw new ForbiddenException("resourceOwner is %s, currentUser is %s", resourceOwnerId,
					currentUser.getId());
		}
	}
}
