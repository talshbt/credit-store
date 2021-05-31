package com.example.otp.services.impl;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.example.otp.beans.CustomerDetails;
import com.example.otp.exception.OtpNotExistException;
import com.example.otp.services.facade.OtpService;

@Getter
@Data
@Service
public class OtpServiceImpl implements OtpService {

	public static HashMap<String,String> otpMap = new HashMap<>();
	
	@Override
	public String createOtp(CustomerDetails customerDetails) {
		int randomPin   =(int) (Math.random()*9000)+1000;
        String otp  = String.valueOf(randomPin);
        
        otpMap.put(customerDetails.getPhone(), otp);
        otpMap.toString();
        return otp;
        
        }

	@Override
	public boolean validateOtp(String phone, String otp) throws OtpNotExistException {
		String otpFromMap = otpMap.get(phone);
		if(otpFromMap != null)
		{
			if(!otpFromMap.equals(otp))
			{
				return false;
			}
			return true;
		}
		throw new ResponseStatusException(HttpStatus.NON_AUTHORITATIVE_INFORMATION, "otp not exist in DB");
	}
}
