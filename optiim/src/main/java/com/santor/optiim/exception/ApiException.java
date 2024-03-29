package com.santor.optiim.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message ;
    private  Throwable throwable;
    private final HttpStatus httpStatus;
    private  ZonedDateTime zonedDateTime;

    public  ApiException(String message,
                         Throwable throwable,
                         HttpStatus httpStatus,
                         ZonedDateTime zonedDateTime){

        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
    public  ApiException(String message,
                         HttpStatus httpStatus){

        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
