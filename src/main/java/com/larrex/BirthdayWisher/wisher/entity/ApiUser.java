package com.larrex.BirthdayWisher.wisher.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "api_user")
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String key;

}
