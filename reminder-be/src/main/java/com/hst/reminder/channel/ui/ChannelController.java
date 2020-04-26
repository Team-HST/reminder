package com.hst.reminder.channel.ui;

import com.hst.reminder.channel.application.ChannelService;
import com.hst.reminder.channel.ui.request.ChannelModifyingRequest;
import com.hst.reminder.configuration.SwaggerConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
