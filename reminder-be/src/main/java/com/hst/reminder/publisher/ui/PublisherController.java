package com.hst.reminder.publisher.ui;

import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.ui.request.PublisherModifyingRequest;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
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
public class PublisherController {

	private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);

	@Autowired
	private PublisherService publisherService;

	@GetMapping("by-member/{memberId}")
	public ResponseEntity<PublisherListResponse> getPublisherByMemberId(@PathVariable Long memberId) {
		PublisherListResponse response = publisherService.getPublishersByMemberId(memberId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{publisherId}")
	public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long publisherId) {
		PublisherResponse response = publisherService.getPublisher(publisherId);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<Long> createPublisher(@RequestBody PublisherModifyingRequest request) {
		Long createdPublisherId = publisherService.createPublisher(request);
		return ResponseEntity.ok(createdPublisherId);
	}

	@PutMapping("{publisherId}")
	public ResponseEntity<String> updatePublisher(@PathVariable("publisherId") Long publisherId,
												  @RequestBody PublisherModifyingRequest request) {
		publisherService.updatePublisher(publisherId, request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<String> deletePublishers(@RequestBody List<Long> publisherIds) {
		publisherService.deletePublishers(publisherIds);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{publisherId}")
	public ResponseEntity<String> deletePublisher(@PathVariable("publisherId") Long publisherId) {
		publisherService.deletePublisher(publisherId);
		return ResponseEntity.ok().build();
	}

}
