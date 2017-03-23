package com.springmail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SpringMailImpl implements SpringMail {

	private final Log LOGGER = LogFactory.getLog(SpringMailImpl.class);

	@Autowired
	private SimpleMailMessage mailMessage;

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendMail(String to, String subject, String body) {
		LOGGER.debug("SpringMailImpl start - sendMail");
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailSender.send(mailMessage);
		LOGGER.debug("SpringMailImpl end - sendMail");
	}

}
