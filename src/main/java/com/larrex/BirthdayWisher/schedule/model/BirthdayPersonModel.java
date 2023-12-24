package com.larrex.BirthdayWisher.schedule.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data

public class BirthdayPersonModel {

    private Long wisherId;
    private String birthdayPersonName;
    private String wisherName;
    private String email;
    private String birthdayMessage;
    private Date birthday;

}
