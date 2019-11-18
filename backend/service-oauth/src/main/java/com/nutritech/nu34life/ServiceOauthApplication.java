package com.nutritech.nu34life;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class ServiceOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOauthApplication.class, args);
	}

}
