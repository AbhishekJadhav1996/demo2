package com.cybage;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@EnableJpaAuditing
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("webmail.evolvingsols.com");
	        mailSender.setPort(587);
	          
	        mailSender.setUsername("Trng1");
	        mailSender.setPassword("Cyb@ge@531");
	          
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable.required", "true");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.ssl.enable.trust", "*");
	        return mailSender;
	 }

}
