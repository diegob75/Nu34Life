package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "diet_days", uniqueConstraints = { @UniqueConstraint(columnNames = { "diet_id", "day" })})
public class DietDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    public Diet diet;

    public Short day;

    @OneToMany(mappedBy = "dietDay")
    public List<DietDayDetail> details;
}
