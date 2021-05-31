package com.example.otp.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.otp.exception.OtpNotExistException;
import com.example.otp.web.model.ErrorDetails;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {

    @ExceptionHandler(OtpNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException2(OtpNotExistException ex, WebRequest req){
        return new ErrorDetails(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),req.getParameter("id"));

    }
}