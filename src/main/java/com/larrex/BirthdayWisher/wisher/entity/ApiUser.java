package com.larrex.BirthdayWisher.wisher.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "api_user")
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 32)
    private String email;
    private String apikey;


    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Timestamp created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

}
