package com.hst.reminder.publisher.ui;

import com.hst.reminder.configuration.SwaggerConfiguration;
import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.ui.request.PublisherModifyingRequest;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("publishers")
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.PUBLISHER_API_TAG)
public class PublisherController {
	private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);

	private final PublisherService publisherService;

	@ApiOperation(value = "발행자 조회", notes = "발행자를 조회합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "publisherId",
					value = "조회할 발행자의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@GetMapping("{publisherId}")
	public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long publisherId) {
		PublisherResponse response = publisherService.getPublisher(publisherId);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "발행자 등록", notes = "발행자를 등록합니다.")
	@PostMapping
	public ResponseEntity<Long> createPublisher(@RequestBody PublisherModifyingRequest request) {
		Long createdPublisherId = publisherService.createPublisher(request);
		return ResponseEntity.ok(createdPublisherId);
	}

	@ApiOperation(value = "발행자 수정", notes = "발행자를 수정합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "publisherId",
					value = "수정할 발행자의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@PutMapping("{publisherId}")
	public ResponseEntity<String> modifyPublisher(@PathVariable("publisherId") Long publisherId,
												  @RequestBody PublisherModifyingRequest request) {
		publisherService.modifyPublisher(publisherId, request);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "발행자 다 건 삭제", notes = "다 건의 발행자를 삭제합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "publisherIds",
					value = "삭제할 발행자의 ID 목록",
					example = "[1, 2]",
					required = true,
					dataType = "long",
					paramType = "body"
			),
	})
	@DeleteMapping
	public ResponseEntity<String> deletePublishers(@RequestBody List<Long> publisherIds) {
		publisherService.deletePublishers(publisherIds);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "발행자 삭제", notes = "발행자를 삭제합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "publisherId",
					value = "삭할 발행자의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@DeleteMapping("{publisherId}")
	public ResponseEntity<String> deletePublisher(@PathVariable("publisherId") Long publisherId) {
		publisherService.deletePublisher(publisherId);
		return ResponseEntity.ok().build();
	}

}
