package com.hrms.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "designations")
@Data
public class Designation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}