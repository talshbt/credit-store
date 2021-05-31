package com.example.otp.exception;

import org.springframework.http.HttpStatus;

public class OtpNotExistException extends Exception {

	private static final long serialVersionUID = 5389979505000487353L;

	public OtpNotExistException(String msg)
    {
        super(msg);
    }
}

