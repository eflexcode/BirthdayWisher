package com.larrex.BirthdayWisher.wisher.model;

import lombok.Data;

@Data
public class AuthMailObj {

    private String receiverEmail;
    private String body;
    private String subject;

}
