package com.example.demo.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Admin {
    private int adminId;
    private String adminName;
    private LocalDateTime createdAt;
}
