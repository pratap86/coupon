package com.pratap.coupon.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponRequestModel {

    private String code;
    private BigDecimal discount;
    private Date expDate;
}
