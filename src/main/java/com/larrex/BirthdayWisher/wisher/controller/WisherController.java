package com.larrex.BirthdayWisher.wisher.controller;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.model.ResponseMessage;
import com.larrex.BirthdayWisher.wisher.service.ApiUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wisher/")
@RequiredArgsConstructor
public class WisherController {

    private final ApiUserService apiUserService;

    @PostMapping("{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createApiUser(@PathVariable(name = "email") String email){
        return apiUserService.createApiUser(email);
    }
    @DeleteMapping("{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteApiUser(@PathVariable(name = "email") String email) throws ItemNotFoundException {
        return apiUserService.delete(email);
    }

}
