package com.springmail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class App {

	private static final List<String> mailList = Arrays.asList("test@126.com");

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
			SpringMailImpl springMailImpl = (SpringMailImpl) context.getBean("springMailImpl");
			for (String mail : mailList) {
				springMailImpl.sendMail(mail, "jiangdp Test Mail", "Test Mail Body To" + mail );
			}
		}
	}
}
