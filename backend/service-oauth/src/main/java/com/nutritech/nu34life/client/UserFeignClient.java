package com.nutritech.nu34life.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.nutritech.nu34life.model.entity.Account;

@FeignClient(name = "service-users", url = "localhost:9008")
public interface UserFeignClient {

	@GetMapping("/users/getByUserName")
	Account findByUserName(@RequestParam String username);

}
