package com.hst.reminder.channel.domain;

import com.hst.reminder.channel.ui.request.ChannelModifyingRequest;
import com.hst.reminder.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "CHANNEL")
@NoArgsConstructor
@Getter
public class Channel extends BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = -591464735624092809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column(name = "member_id")
	private Long memberId;

	@OneToMany(mappedBy = "channel")
	private List<ChannelPublisher> publishers = new ArrayList<>();

	/***
	 * 채널에 발행자 할당
	 * @param publisher 할당할 발행자
	 */
	public void linkPublisher(ChannelPublisher publisher) {
		this.publishers.add(publisher);
	}

	public static Channel from(ChannelModifyingRequest request) {
		Channel channel = new Channel();
		channel.title = request.getTitle();
		channel.description = request.getDescription();
		channel.memberId = request.getMemberId();
		return channel;
	}
}
