package com.larrex.BirthdayWisher.wisher.seviceimple;

import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.wisher.repository.ApiUserRepository;
import com.larrex.BirthdayWisher.wisher.service.ApiUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiUserServiceImpl implements ApiUserService {

    private final ApiUserRepository apiUserRepository;

    @Override
    public void CreateApiUser(String email) {

        String key = UUID.randomUUID().toString();

        ApiUser apiUser = new ApiUser();
        apiUser.setEmail(email);
        apiUser.setKey(key);

        apiUserRepository.save(apiUser);
    }

    @Override
    public ApiUser getApiUser(String email) throws ItemNotFoundException {
        return apiUserRepository.findByEmail(email).orElseThrow(()-> new ItemNotFoundException("No Api user found with email: "+email));
    }

    @Override
    public void delete(String email) throws ItemNotFoundException {

        ApiUser apiUser = getApiUser(email);
        apiUserRepository.delete(apiUser);

    }
}
