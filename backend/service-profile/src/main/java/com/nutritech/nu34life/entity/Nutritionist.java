package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;

import com.nutritech.nu34life.util.Account;

import java.util.List;

@Data
@Entity
@Table(name = "nutritionists")
public class Nutritionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column 
    private String firstName;
    
    @Column
    private String lastName;
    
    @Column
    private String imagen;
	
	@OneToOne(targetEntity = Account.class)
	@JoinColumn(name = "user_id")
	private Account idUser;

	
    @OneToMany(mappedBy = "nutritionist", cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE}, orphanRemoval = true)
    private List<Affiliation> patients;
}
