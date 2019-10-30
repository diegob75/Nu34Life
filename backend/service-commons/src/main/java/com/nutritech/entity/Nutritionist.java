package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "nutritionists")
public class Nutritionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

    @OneToMany(mappedBy = "nutritionist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Affiliation> patients;
}
