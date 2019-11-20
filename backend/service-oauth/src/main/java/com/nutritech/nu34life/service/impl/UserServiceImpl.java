package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.client.UserFeignClient;
import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.service.UserService;
import com.nutritech.nu34life.util.UserResponse;


@Service
public class UserServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserFeignClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) 
			 throws UsernameNotFoundException {

		UserResponse user = userClient.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(
					"Error en el login, no existe el usuario " 
			+ username + " en el sistema");
		}

		List<GrantedAuthority> authorities = 
				user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(
						role.getName()))
				.collect(Collectors.toList());

		return new User(user.getUsername(), user.getPassword(), 
				user.getEmailValidated(), true, true, true, authorities);
	}

	@Override
	public UserResponse findByUsername(String username) {
		return userClient.findByUserName(username);
	}

	
	
}




