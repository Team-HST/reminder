package com.hst.reminder.publisher.ui;

import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.ui.request.CreatePublisherRequest;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("publisher")
public class PublisherController {

	private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);

	@Autowired
	private PublisherService publisherService;

	@PostMapping
	public ResponseEntity<Long> createPublisher(@RequestBody CreatePublisherRequest request) {
		Long createdPublisherId = publisherService.createPublisher(request);
		return ResponseEntity.ok(createdPublisherId);
	}

	@GetMapping("{publisherId}")
	public ResponseEntity<PublisherResponse> greet(@PathVariable Long publisherId) {
		PublisherResponse response = publisherService.getPublisher(publisherId);
		return ResponseEntity.ok(response);
	}

}
