package com.nutritech.nu34life.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.Email;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Email email) {
		MimeMessage msg = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			
			helper.setTo(email.getSendTo());
			helper.setSubject(email.getHeader());
			helper.setText(email.getCuerpo(),true);
			javaMailSender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
