package com.nutritech.nu34life.util;



import java.time.LocalDate;
import java.util.List;

import com.nutritech.nu34life.model.entity.Role;

import lombok.Data;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String imagen;
	private Long userId;
	private String password;
	private String username;
	private String email;
	private Double weight;
	private Double height;
	private Long profileId;
	private Boolean emailValidated;
	private int accountStatus;
	private LocalDate registerDate;
	private Boolean profileCreated;
	private List<Role>roles;
}
