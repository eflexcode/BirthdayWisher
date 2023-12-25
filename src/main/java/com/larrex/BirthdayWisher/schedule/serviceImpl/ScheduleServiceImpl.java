package com.larrex.BirthdayWisher.schedule.serviceImpl;

import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.Util;
import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.schedule.repository.ScheduleRepository;
import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final JavaMailSender javaMailSender;

    @Override
    public ResponseMessage addBirthdayToQueue(List<BirthdayPerson> birthdayPeople) {

        scheduleRepository.saveAll(birthdayPeople);

        return new ResponseMessage("All birthdays saved an wishes would be sent in there date ");
    }

    @Override
    public List<BirthdayPerson> getAllTodayBirthday() {
        return scheduleRepository.getAllTodayBirthday();
    }

    @Override
    public void sendTokenToEmail(BirthdayPerson birthdayPerson) throws MessagingException, UnsupportedEncodingException, MailjetException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);

        mimeMessageHelper.setFrom(Util.SENDER,"BirthdayWisherApi");
        mimeMessageHelper.setTo(birthdayPerson.getEmail());
        mimeMessageHelper.setSubject("Happy birthday "+birthdayPerson.getBirthdayPersonName()+" from "+birthdayPerson.getWisherName());
        mimeMessageHelper.setText(birthdayPerson.getBirthdayMessage());
        javaMailSender.send(mimeMailMessage);
    }


}
