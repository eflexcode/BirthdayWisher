package com.larrex.BirthdayWisher.schedule.repository;

import com.larrex.BirthdayWisher.schedule.entity.BirthdayPerson;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<BirthdayPerson,Long> {

//    SELECT  *  FROM birthday_wisher.birthday_person WHERE DATE("2024-01-12") = CURDATE()

    @Query( value = "SELECT * FROM birthday_person WHERE DATE(birthday) = CURDATE()",nativeQuery = true)
    List<BirthdayPerson> getAllTodayBirthday();

}
