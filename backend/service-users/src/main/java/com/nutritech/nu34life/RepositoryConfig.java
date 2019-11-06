package com.nutritech.nu34life;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.model.entity.Role;

@Configuration
public class RepositoryConfig  
		implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Account.class,Role.class);
	}	
}
