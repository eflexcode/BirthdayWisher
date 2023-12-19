package com.larrex.BirthdayWisher.wisher.repository;

import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser,Long> {

    Optional<ApiUser> findByApikey(String apikey);
    Optional<ApiUser> findByEmail(String email);
}
