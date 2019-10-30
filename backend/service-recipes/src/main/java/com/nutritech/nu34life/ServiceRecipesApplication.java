package com.nutritech.nu34life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.nutritech.entity")
@SpringBootApplication
public class ServiceRecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRecipesApplication.class, args);
	}

}
