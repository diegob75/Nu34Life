package com.nutritech.nu34life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServiceRecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRecipesApplication.class, args);
	}
}
