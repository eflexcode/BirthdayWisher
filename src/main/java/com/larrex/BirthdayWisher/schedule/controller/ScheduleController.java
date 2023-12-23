package com.larrex.BirthdayWisher.schedule.controller;

import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import com.larrex.BirthdayWisher.ResponseMessage;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createApiUser()  {
        return new ResponseMessage("worked");
    }

}
