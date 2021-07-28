package com.pratap.coupon.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponDto {

    private Long id;
    private String couponId;
    private String code;
    private BigDecimal discount;
    private Date expDate;
}
