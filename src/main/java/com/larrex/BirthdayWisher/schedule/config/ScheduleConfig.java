package com.larrex.BirthdayWisher.schedule.config;

import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ScheduleConfig {

    private final ScheduleService scheduleService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleSendTodayWishes() {
        List<BirthdayPerson> allTodayBirthday = scheduleService.getAllTodayBirthday();


    }

}
