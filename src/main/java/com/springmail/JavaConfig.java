package com.springmail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan
public class JavaConfig {

	@Bean(name = "mailSender")
	public JavaMailSenderImpl getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");
		mailSender.setPort(25);
		mailSender.setUsername("temp@qq.com");
		mailSender.setPassword("123123");
		mailSender.setDefaultEncoding("UTF-8");
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean(name = "mailMessage")
	public SimpleMailMessage getSimpleMailMsg() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("temp@qq.com");
		return mailMessage;
	}

}
