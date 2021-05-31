package com.example.otp.services.facade;

import com.example.otp.beans.CustomerDetails;
import com.example.otp.exception.OtpNotExistException;

public interface OtpService {

        String createOtp(CustomerDetails customerDetails);

		boolean validateOtp(String phone, String otp) throws OtpNotExistException;

}
