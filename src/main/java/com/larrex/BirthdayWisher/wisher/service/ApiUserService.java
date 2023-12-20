package com.larrex.BirthdayWisher.wisher.service;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.wisher.model.ResponseMessage;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface ApiUserService {

    ResponseMessage createApiUser(String email) throws MessagingException, UnsupportedEncodingException;
    ResponseMessage resendToken(String email) throws ItemNotFoundException, MessagingException, UnsupportedEncodingException;
    ApiUser getApiUser(String email) throws ItemNotFoundException;
    ResponseMessage delete(String email) throws ItemNotFoundException;

    void sendTokenToEmail(String email,String token) throws MessagingException, UnsupportedEncodingException;

}
