package com.cybage.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
@Service
public class EmailService {
	
	public  void sendEmail(String to,String message) {
	//	 Random rnd = new Random();
		   // int number = rnd.nextInt(999999);
		String from="Trng1@evolvingsols.com";
//		="your OTP is:"+number;
		String subject="Regarding otp verification";
		//Variable for gmail
	//	String host="webmail.evolvingsols.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
	//	properties.put("mail.transport.protocol", "smtp");
	properties.put("mail.smtp.starttls.enabled.required", "true");
		properties.put("mail.smtp.host", "webmail.evolvingsols.com");
	
	
//	properties.put("mail.smtp.starttls.enable", "false");
		
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.ssl.enable","false");
		properties.put("mail.smtp.ssl.trust", "*");
//		properties.put("mail.smtp.ssl.protocols","TLSv1.2");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.username","username(Trng1)");
		  properties.put("mail.smtp.password","password(Cyb@ge@531)");
	  properties.put("mail.smtp.socketFactory.port",587 );
		 properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 properties.put("mail.smtp.socketFactory.fallback", "true");
		//Session session=Session.getDefaultInstance(properties,null);
		
	//	Step 1: to get the session object..
		Session session=Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("Trng1", "Cyb@ge@531");
			}
			
			
			
		});
//		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
	
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
