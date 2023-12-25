package com.larrex.BirthdayWisher.schedule.service;

import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleService {

    ResponseMessage addBirthdayToQueue(List<BirthdayPerson> birthdayPeople);
    List<BirthdayPerson> getAllTodayBirthday();
}
