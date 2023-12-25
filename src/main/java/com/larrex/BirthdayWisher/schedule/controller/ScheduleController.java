package com.larrex.BirthdayWisher.schedule.controller;

import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.schedule.model.BirthdayPersonModel;
import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import com.larrex.BirthdayWisher.ResponseMessage;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createApiUser(@RequestBody List<BirthdayPerson> personModel)  {
        return scheduleService.addBirthdayToQueue(personModel);
    }

    @GetMapping("/get/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<BirthdayPerson> createApiUser(@PathVariable(name = "date") String date)  {
        return scheduleService.getAllTodayBirthday();
    }

}
