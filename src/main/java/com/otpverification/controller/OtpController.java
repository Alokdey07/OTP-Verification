package com.otpverification.controller;

import com.otpverification.payload.OtpDto;
import com.otpverification.payload.PhoneDto;
import com.otpverification.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class OtpController {

    @Autowired
    private OtpService otpService;

    private Map<String, String> otpStorage = new HashMap<>();

    //This is with query parameter
    @PostMapping("/send-otp")//This is with query parameter
    public String sendOtp(@RequestParam String phoneNumber){
        // Generate a random OTP (you can use libraries like java.util.Random)
        String otp = generateRandomOtp();

        if(otpService.sendOtp("+"+phoneNumber,otp)){
            otpStorage.put("+"+phoneNumber,otp);
            return "OTP sent successfully";
        }else {
            return "failed to send OTP";
        }
    }


    @PostMapping("/send_otp")//This is with DTO Object
    public String sendOtpJson(@RequestBody PhoneDto dto){
        // Generate a random OTP (you can use libraries like java.util.Random)
        String otp = generateRandomOtp();

        if(otpService.sendOtp(dto.getPhoneNumber(),otp)){
            otpStorage.put(dto.getPhoneNumber(), otp);
            return "OTP sent successfully";
        }else {
            return "failed to send OTP";
        }
    }



    @PostMapping("/verify-otp")//This is with DTO Object
    public String verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp){
        String storedOtp= otpStorage.get("+"+phoneNumber);
        if(storedOtp!=null && storedOtp.equals(otp) ){
            otpStorage.remove("+"+phoneNumber);
            return "OTP verified successfully";
        }else {
            return "Invalid OTP";
        }
    }

    @PostMapping("/verify_otp") //This is with DTO Object
    public String verifyOtpjson(@RequestBody OtpDto dto){
        String storedOtp= otpStorage.get(dto.getPhoneNumber());
        System.out.println(storedOtp);
        System.out.println(dto.getOtp());
        if(storedOtp !=null && storedOtp.equals(dto.getOtp())){
            otpStorage.remove(dto.getPhoneNumber());
            return "OTP verified successfully";
        }else {
            return "Invalid OTP";
        }
    }



    private String generateRandomOtp(){
        //Genrate a 6-digit OTP
        Random random =new Random();
        int otpValue = 100000+ random.nextInt(900000);
        return String.valueOf(otpValue);
    }


}
