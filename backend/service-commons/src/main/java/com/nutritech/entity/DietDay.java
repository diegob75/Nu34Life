package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "diet_days", uniqueConstraints = { @UniqueConstraint(columnNames = { "diet_id", "day" })})
public class DietDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    private Short day;

    @OneToMany(mappedBy = "dietDay", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DietDayDetail> details;
}
