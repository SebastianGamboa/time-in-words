package com.sgb.timeinwords.controllers;

import com.sgb.timeinwords.shared.models.ResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class TimeControllerAdvice {
    
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseError fileExceptionHandler(MultipartException ex) {
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseError numberExceptionHandler(NumberFormatException ex) {
        return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Invalid time format");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseError exceptionHandler(RuntimeException ex) {
        return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
}
