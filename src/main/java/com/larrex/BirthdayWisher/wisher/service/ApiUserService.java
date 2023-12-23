package com.larrex.BirthdayWisher.wisher.service;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.ResponseMessage;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface ApiUserService {

    ResponseMessage createApiUser(String email) throws MailjetException, MessagingException, UnsupportedEncodingException;
    ResponseMessage resendToken(String email) throws MailjetException, ItemNotFoundException, MessagingException, UnsupportedEncodingException;
    ApiUser getApiUser(String email) throws ItemNotFoundException;
    ApiUser getApiUserToken(String token) throws ItemNotFoundException;
    ResponseMessage delete(String email) throws ItemNotFoundException;

    void sendTokenToEmail(String email,String token) throws MessagingException, UnsupportedEncodingException, MailjetException;

}
