package com.larrex.BirthdayWisher;

import com.larrex.BirthdayWisher.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthdayWisherApplication {
	public static void main(String[] args) {
		SpringApplication.run(BirthdayWisherApplication.class, args);
	}

}
