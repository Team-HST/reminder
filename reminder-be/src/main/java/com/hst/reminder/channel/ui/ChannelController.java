package com.hst.reminder.channel.ui;

import com.hst.reminder.channel.application.ChannelService;
import com.hst.reminder.configuration.SwaggerConfiguration;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping
	public void getChannels() {
		
	}

}
