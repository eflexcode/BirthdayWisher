package com.larrex.BirthdayWisher.exception;

public class ItemNotFoundException extends Exception{

    public static final long serialVersionUID = 1L;

    public ItemNotFoundException(String message) {
        super(message);
    }
}
