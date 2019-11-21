package com.nutritech.nu34life.util;

import lombok.Data;

@Data
public class Patient {
    private String firstName;
    private String lastName;
    private String imagen;
	private Long userId;
	private Double weight;
	private Double height;
	private Long id;
	private Long nutritionistId;
}
