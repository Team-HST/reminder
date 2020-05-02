package com.hst.reminder.member.ui.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@NoArgsConstructor
public class MemberDetailListResponse {
	private List<MemberDetailResponse> memberDetails;

	public static MemberDetailListResponse from(List<MemberDetailResponse> memberDetails) {
		MemberDetailListResponse response = new MemberDetailListResponse();
		response.memberDetails = memberDetails;
		return response;
	}

	public static MemberDetailListResponse empty() {
		return new MemberDetailListResponse();
	}
}
