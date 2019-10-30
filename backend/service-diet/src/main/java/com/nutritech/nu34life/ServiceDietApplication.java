package com.nutritech.nu34life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan("com.nutritech.entity")
public class ServiceDietApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDietApplication.class, args);
	}

}
