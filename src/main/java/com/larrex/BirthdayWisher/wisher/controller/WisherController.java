package com.larrex.BirthdayWisher.wisher.controller;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.wisher.service.ApiUserService;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("wisher/")
@RequiredArgsConstructor
public class WisherController {

    private final ApiUserService apiUserService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createApiUser(@RequestParam(name = "email") String email) throws MailjetException, MessagingException, UnsupportedEncodingException {
        return apiUserService.createApiUser(email);
    }
    @PostMapping("resend")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage resendToken(@RequestParam(name = "email") String email) throws MailjetException, ItemNotFoundException, MessagingException, UnsupportedEncodingException {
        return apiUserService.resendToken(email);
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteApiUser(@RequestParam(name = "email") String email) throws ItemNotFoundException {
        return apiUserService.delete(email);
    }

}
