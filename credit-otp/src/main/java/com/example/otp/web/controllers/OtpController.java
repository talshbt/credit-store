package com.example.otp.web.controllers;

import com.example.otp.beans.CustomerDetails;
import com.example.otp.exception.OtpNotExistException;
import com.example.otp.services.facade.OtpService;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@RequestMapping("otp")
@RestController
public class OtpController {

	@Autowired
    OtpService otpService;

    @PostMapping
    public ResponseEntity<?> createOtp(@RequestBody CustomerDetails customerDetails){
            return new ResponseEntity<>(otpService.createOtp(customerDetails),HttpStatus.CREATED);
    }
    
    @GetMapping()
    public ResponseEntity<?> validateOtp(@RequestParam String phone, String otp) throws OtpNotExistException{
            return new ResponseEntity<>(otpService.validateOtp(phone,otp),HttpStatus.OK);

    }
}
