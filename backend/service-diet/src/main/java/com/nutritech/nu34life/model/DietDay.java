package com.nutritech.nu34life.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.List;

@Data
@Entity
@Table(name = "diet_days", uniqueConstraints = { @UniqueConstraint(columnNames = { "diet_id", "day" })})
public class DietDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    private Short day;

    
    @OneToMany(mappedBy = "dietDay", orphanRemoval = true, cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<DietDayDetail> details;
}
