package com.nutritech.nu34life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServiceDietApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDietApplication.class, args);
	}
}
