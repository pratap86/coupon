package com.pratap.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CouponNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 726896066513752851L;

    public CouponNotFoundException(String message){
        super(message);
    }
}
