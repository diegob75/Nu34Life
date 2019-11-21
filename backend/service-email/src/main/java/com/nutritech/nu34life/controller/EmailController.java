package com.nutritech.nu34life.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.entity.Email;
import com.nutritech.nu34life.service.EmailService;

@RestController
@RequestMapping(path="email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public void sendMessage(@RequestBody Email email) {
		emailService.sendEmail(email);
	}
	
	
}
