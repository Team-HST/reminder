package com.hst.reminder.channel.ui;

import com.hst.reminder.channel.application.ChannelService;
import com.hst.reminder.channel.ui.request.ChannelModifyingRequest;
import com.hst.reminder.configuration.SwaggerConfiguration;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("channels")
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.CHANNEL_API_TAG)
public class ChannelController {
	private final ChannelService channelService;

	@ApiOperation(value = "채널 등록", notes = "채널 등록합니다.")
	@PostMapping
	public ResponseEntity<Long> createChannel(@RequestBody ChannelModifyingRequest request) {
		return ResponseEntity.ok(channelService.createChannel(request));
	}

	@ApiOperation(value = "채널 다 건 삭제", notes = "다 건의 채널을 삭제합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "channelIds",
					value = "삭제할 채널의 ID 목록",
					example = "[1, 2]",
					required = true,
					dataType = "long",
					paramType = "body"
			),
	})
	@DeleteMapping
	public ResponseEntity<String> deletePublishers(@RequestBody List<Long> channelIds) {
		channelService.deleteChannels(channelIds);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "채널 삭제", notes = "채널을 삭제합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "channelId",
					value = "삭할 채널의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@DeleteMapping("{channelId}")
	public ResponseEntity<String> deletePublisher(@PathVariable("channelId") Long channelId) {
		channelService.deleteChannel(channelId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("f")
	public void test() {
		Member m = SecurityUtils.currentUser();
		System.out.println(m);
	}

}
