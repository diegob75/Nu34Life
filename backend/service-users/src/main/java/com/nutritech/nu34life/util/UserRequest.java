package com.nutritech.nu34life.util;

import lombok.Data;
@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String imagen;
	private Long userId;
	private String password;
	private String username;
	private String email;
	private Double weight;
	private Double height;
}
