package com.nutritech.nu34life.util;

import java.time.LocalDate;
import java.util.List;

import com.nutritech.nu34life.model.entity.Role;

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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	public Boolean getEmailValidated() {
		return emailValidated;
	}
	public void setEmailValidated(Boolean emailValidated) {
		this.emailValidated = emailValidated;
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public Boolean getProfileCreated() {
		return profileCreated;
	}
	public void setProfileCreated(Boolean profileCreated) {
		this.profileCreated = profileCreated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountStatus;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailValidated == null) ? 0 : emailValidated.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profileCreated == null) ? 0 : profileCreated.hashCode());
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		if (accountStatus != other.accountStatus)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailValidated == null) {
			if (other.emailValidated != null)
				return false;
		} else if (!emailValidated.equals(other.emailValidated))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profileCreated == null) {
			if (other.profileCreated != null)
				return false;
		} else if (!profileCreated.equals(other.profileCreated))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	public UserResponse(String firstName, String lastName, String imagen, Long userId, String password, String username,
			String email, Double weight, Double height, Long profileId, Boolean emailValidated, int accountStatus,
			LocalDate registerDate, Boolean profileCreated,List<Role>roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.imagen = imagen;
		this.userId = userId;
		this.password = password;
		this.username = username;
		this.email = email;
		this.weight = weight;
		this.height = height;
		this.profileId = profileId;
		this.emailValidated = emailValidated;
		this.accountStatus = accountStatus;
		this.registerDate = registerDate;
		this.profileCreated = profileCreated;
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
