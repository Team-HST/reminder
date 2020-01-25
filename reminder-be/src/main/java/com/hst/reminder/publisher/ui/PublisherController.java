package com.hst.reminder.publisher.ui;

import com.hst.reminder.publisher.ui.request.CreatePublisherRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("publisher")
public class PublisherController {

	private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);

	@GetMapping("{publisherId}")
	public ResponseEntity<String> greet(@PathVariable Long publisherId) {
		return null;
	}

	@PostMapping
	public ResponseEntity<String> createPublisher(@RequestBody CreatePublisherRequest request) {
		logger.info("{}", request);
		return null;
	}

}
