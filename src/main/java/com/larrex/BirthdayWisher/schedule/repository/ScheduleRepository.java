package com.larrex.BirthdayWisher.schedule.repository;

import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<BirthdayPerson,Long> {


}
