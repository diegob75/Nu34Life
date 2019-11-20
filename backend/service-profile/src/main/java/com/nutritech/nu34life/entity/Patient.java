package com.nutritech.nu34life.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nutritech.nu34life.util.Account;

@Data
@Entity
@Table(name = "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
	@JsonIgnore
	@OneToOne(targetEntity = Account.class)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Account user;
	
	@Column(name = "user_id", unique = true)
	private Long userId;
	
	@Column
    private Double height;
    
    @Column
    private Double weight;
    
    @Column 
    private String firstName;
    
    @Column
    private String lastName;
    
    @Column
    private String imagen;
	
    @ManyToOne
    @JoinColumn(name = "current_nutritionist", insertable = false, updatable = false)
    private Nutritionist nutritionist;
    
    @Column(name = "current_nutritionist")
    private Long nutritionistId;
    
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Affiliation> patients;
}
