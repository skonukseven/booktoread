package com.booktoread.domain;

import com.booktoread.domain.Enumaration.UserRole;
import jakarta.persistence.*;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private UserRole name;

    @Override
    public String toString() {
        return "{" + name + '}';
    }
}
