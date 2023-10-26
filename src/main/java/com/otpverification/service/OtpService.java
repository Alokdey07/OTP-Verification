package com.otpverification.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number}")
    private String twillioPhoneNumber;

    public boolean sendOtp(String to, String otp){
        Twilio.init(accountSid,authToken);
        try{
            Message.creator(new PhoneNumber(to),new PhoneNumber(twillioPhoneNumber),"Your OTP is:"+ otp).create();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
