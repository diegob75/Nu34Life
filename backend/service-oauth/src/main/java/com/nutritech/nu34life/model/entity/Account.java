package com.nutritech.nu34life.model.entity;


import java.util.List;
import java.util.Date;

public class Account {

	private Long id;	

	private int accountStatus;

	private String email;
	
	private Boolean emailValidated;
	
	private String password;
	
	private Date registerDate;

	private String username;
	
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailValidated() {
		return emailValidated;
	}

	public void setEmailValidated(Boolean emailValidated) {
		this.emailValidated = emailValidated;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	

}
