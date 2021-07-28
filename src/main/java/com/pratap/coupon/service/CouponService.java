package com.pratap.coupon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pratap.coupon.dto.CouponDto;

public interface CouponService {

    CouponDto create(CouponDto couponDto) throws Exception;
    CouponDto getCoupon(String code);
}
