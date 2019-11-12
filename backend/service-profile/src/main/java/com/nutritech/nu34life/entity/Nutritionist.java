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
	
	@OneToOne(targetEntity = Account.class)
	@JoinColumn(name = "user_id")
	private Long idUser;

    @OneToMany(mappedBy = "nutritionist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Affiliation> patients;
}
