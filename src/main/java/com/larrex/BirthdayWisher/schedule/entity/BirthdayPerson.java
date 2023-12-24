package com.larrex.BirthdayWisher.schedule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Table(name = "birthday_person")
@Entity
public class BirthdayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long wisherId;
    private String birthdayPersonName;
    private String wisherName;
    private String email;
    private String birthdayMessage;
    private Date birthday;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Timestamp created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

}
