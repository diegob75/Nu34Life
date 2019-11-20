package com.nutritech.nu34life.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nutritech.nu34life.util.UserResponse;

@FeignClient(name = "service-users")
public interface UserFeignClient {

	@GetMapping("/users/getByUserName")
	UserResponse findByUserName(@RequestParam String username);

}
