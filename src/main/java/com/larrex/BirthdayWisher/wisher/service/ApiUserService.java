package com.larrex.BirthdayWisher.wisher.service;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.wisher.model.ResponseMessage;

public interface ApiUserService {

    ResponseMessage createApiUser(String email);
    ApiUser getApiUser(String email) throws ItemNotFoundException;
    ResponseMessage delete(String email) throws ItemNotFoundException;

}
