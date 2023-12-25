package com.larrex.BirthdayWisher.schedule.service;

import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import org.springframework.data.repository.query.Param;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ScheduleService {

    ResponseMessage addBirthdayToQueue(List<BirthdayPerson> birthdayPeople);
    List<BirthdayPerson> getAllTodayBirthday();

    void sendTokenToEmail(BirthdayPerson birthdayPerson) throws MessagingException, UnsupportedEncodingException, MailjetException;

}
