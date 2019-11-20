package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nutritech.nu34life.util.Account;

import java.util.List;

@Data
@Entity
@Table(name = "nutritionists")
public class Nutritionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
    @Column 
    private String firstName;
    
    @Column
    private String lastName;
    
    @Column
    private String imagen;
	
    @JsonIgnore
	@OneToOne(targetEntity = Account.class)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Account user;
	
	@Column(name = "user_id")
	private Long userId;
}
