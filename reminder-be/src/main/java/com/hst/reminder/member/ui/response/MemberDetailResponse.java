package com.hst.reminder.member.ui.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class MemberDetailResponse {
	private MemberProfileResponse profile;
	@JsonUnwrapped
	private PublisherListResponse publishers;

	public static MemberDetailResponse of(MemberProfileResponse profile, PublisherListResponse publishers) {
		MemberDetailResponse response = new MemberDetailResponse();
		response.profile = profile;
		response.publishers = publishers;
		return response;
	}
}
