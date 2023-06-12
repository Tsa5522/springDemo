package com.myDemo.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    private Role role;
}