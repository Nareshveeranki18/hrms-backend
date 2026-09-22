package com.hrms.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "organizations")
@Data
public class Organization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    private String address;
    private String contactEmail;
}