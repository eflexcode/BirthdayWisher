package com.larrex.BirthdayWisher.wisher.service;

import com.larrex.BirthdayWisher.wisher.entity.ApiUser;

public interface ApiUserService {

    void CreateApiUser(String email);
    ApiUser getApiUser(Long id);
    void delete(String email);

}
