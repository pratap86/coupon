package com.pratap.coupon.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponResponseModel {

    private String couponId;
    private String code;
    private BigDecimal discount;
    private Date expDate;
}
