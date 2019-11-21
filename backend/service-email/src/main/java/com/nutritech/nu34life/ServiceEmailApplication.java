package com.nutritech.nu34life;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@EnableEurekaClient
@SpringBootApplication
public class ServiceEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEmailApplication.class, args);
	}
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
         
        mailSender.setUsername("nutritech.no.reply@gmail.com");
        mailSender.setPassword("nu34life#");
         
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
         
        return mailSender;
    }
}
