package com.nutritech.nu34life.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.nutritech.nu34life.model.entity.Account;

@FeignClient(name = "service-users")
public interface UserFeignClient {

	@GetMapping("/users/getByUserName")
	Account findByUserName(@PathVariable String username);

}
