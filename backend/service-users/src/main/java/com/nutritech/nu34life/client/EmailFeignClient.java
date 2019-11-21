package com.nutritech.nu34life.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nutritech.nu34life.util.Email;

@FeignClient(name="service-email")
public interface EmailFeignClient {
	@PostMapping(path = "/email")
	public void sendEmail(@RequestBody Email email);
}
