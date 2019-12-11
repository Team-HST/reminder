package com.hst.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author hyungyu.lee@nhn.com
 */
@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("deveely@kakao.com", "lyupyo@kakao.com");
		mailMessage.setSubject("HST WWL Notification");
		mailMessage.setText("하하하하하하항");
		emailSender.send(mailMessage);
	}

}
