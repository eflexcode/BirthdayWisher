package com.larrex.BirthdayWisher.wisher.service;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;

public interface ApiUserService {

    void CreateApiUser(String email);
    ApiUser getApiUser(String email) throws ItemNotFoundException;
    void delete(String email) throws ItemNotFoundException;

}
