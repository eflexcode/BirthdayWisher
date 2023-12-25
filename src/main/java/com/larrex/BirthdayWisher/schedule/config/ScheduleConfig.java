package com.larrex.BirthdayWisher.schedule.config;

import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ScheduleConfig {

    private final ScheduleService scheduleService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleSendTodayWishes() throws MessagingException, UnsupportedEncodingException, MailjetException {
        List<BirthdayPerson> allTodayBirthday = scheduleService.getAllTodayBirthday();

        for (BirthdayPerson birthdayPerson : allTodayBirthday) {
            scheduleService.sendTokenToEmail(birthdayPerson);
        }
    }

}
