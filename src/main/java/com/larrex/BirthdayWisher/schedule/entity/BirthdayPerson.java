package com.larrex.BirthdayWisher.schedule.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "birthday_person")
@Entity
public class BirthdayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String birthdayPersonName;
    private String wisherName;
    private String email;
    private String birthdayMessage;
    private Date birthday;

}
