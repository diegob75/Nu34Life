package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Enumerated(EnumType.ORDINAL)
    private SubscriptionStatus status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
