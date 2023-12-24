package com.larrex.BirthdayWisher.wisher.seviceimple;

import com.larrex.BirthdayWisher.Util;
import com.larrex.BirthdayWisher.exception.ItemNotFoundException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.wisher.model.AuthMailObj;
import com.larrex.BirthdayWisher.ResponseMessage;
import com.larrex.BirthdayWisher.wisher.repository.ApiUserRepository;
import com.larrex.BirthdayWisher.wisher.service.ApiUserService;
import com.mailjet.client.errors.MailjetException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiUserServiceImpl implements ApiUserService {

    private final ApiUserRepository apiUserRepository;
    private final JavaMailSender javaMailSender;

    @Override
    public ResponseMessage createApiUser(String email) throws MailjetException, MessagingException, UnsupportedEncodingException {

        String apikey = UUID.randomUUID().toString();

        ApiUser apiUser = new ApiUser();
        apiUser.setEmail(email);
        apiUser.setApikey(apikey);

        apiUserRepository.save(apiUser);
        sendTokenToEmail(email,apikey,apiUser.getId());
        return new ResponseMessage("Api key sent to: "+email);
    }

    @Override
    public ResponseMessage resendToken(String email) throws MailjetException, ItemNotFoundException, MessagingException, UnsupportedEncodingException {
        ApiUser apiUser = getApiUser(email);
        sendTokenToEmail(email,apiUser.getApikey(),apiUser.getId());
        return new ResponseMessage("Api key sent to: "+email);
    }

    @Override
    public ApiUser getApiUser(String email) throws ItemNotFoundException {
        return apiUserRepository.findByEmail(email).orElseThrow(()-> new ItemNotFoundException("No Api user found with email: "+email));
    }

    @Override
    public ApiUser getApiUserToken(String token) throws ItemNotFoundException {
        return apiUserRepository.findByApikey(token).orElseThrow(()-> new ItemNotFoundException("No Api user found with token: "+token));
    }

    @Override
    public ResponseMessage delete(String email) throws ItemNotFoundException {

        ApiUser apiUser = getApiUser(email);
        apiUserRepository.delete(apiUser);

        return new ResponseMessage("Api user deleted");
    }

    @Override
    public void sendTokenToEmail(String email, String token,Long apiUserId) throws MailjetException, MessagingException, UnsupportedEncodingException {

        AuthMailObj authMailObj = new AuthMailObj();
        authMailObj.setReceiverEmail(email);
        authMailObj.setSubject("Your Apikey");
        authMailObj.setBody("");
//        // don't know why any of this are not working
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setSubject("Your Apikey");
//        simpleMailMessage.setFrom(Util.SENDER);
//        simpleMailMessage.setTo(email);
//        simpleMailMessage.setText("Here is your birthday wisher api key: "+token);
//
//        javaMailSender.send(simpleMailMessage);

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);

        mimeMessageHelper.setFrom(Util.SENDER,"BirthdayWisherApi");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Your Apikey");
        mimeMessageHelper.setText("Hi, here is your BirthdayWisher apikey: "+token+ " and your userid is "+apiUserId);
        javaMailSender.send(mimeMailMessage);


    }
}
