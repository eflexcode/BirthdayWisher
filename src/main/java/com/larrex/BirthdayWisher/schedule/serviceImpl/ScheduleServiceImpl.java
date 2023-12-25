package com.larrex.BirthdayWisher.schedule.serviceImpl;

import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.schedule.repository.ScheduleRepository;
import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ResponseMessage addBirthdayToQueue(List<BirthdayPerson> birthdayPeople) {

        scheduleRepository.saveAll(birthdayPeople);

        return new ResponseMessage("All birthdays saved an wishes would be sent in there date ");
    }

    @Override
    public List<BirthdayPerson> getAllTodayBirthday() {
        return scheduleRepository.getAllTodayBirthday();
    }


}
