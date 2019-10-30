package com.nutritech.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String firstName;

    @Column
    protected String lastName;

    @Column(unique = true)
    protected String email;

    @Column(unique = true)
    protected String username;

    @Column
    protected String passwordHash;

    @Column(updatable = false)
    protected String passwordSalt;

    @Column
    protected String passwordHint;

    @Column
    protected LocalDate birthday;

    @Column
    protected Boolean emailValidated;

    @Column
    @Enumerated(EnumType.ORDINAL)
    protected AccountStatus accountStatus;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column
    protected LocalDateTime registerDate;
}
