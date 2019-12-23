package com.hst.reminder;

import com.hst.reminder.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReminderApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void sendMailTest() {
		emailService.sendMail();
	}

}
