package com.pratap.coupon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratap.coupon.dto.CouponDto;
import com.pratap.coupon.model.request.CouponRequestModel;
import com.pratap.coupon.model.response.CouponResponseModel;
import com.pratap.coupon.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/coupons")
public class CouponRestController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private ObjectMapper jsonMapper;

    @PostMapping
    public ResponseEntity<CouponResponseModel> createCoupon(@RequestBody CouponRequestModel couponRequestModel) throws Exception {

        log.info("Executing createCoupon() with payload={}", jsonMapper.writeValueAsString(couponRequestModel));

        CouponDto savedCoupon = couponService.create(new ModelMapper().map(couponRequestModel, CouponDto.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ModelMapper().map(savedCoupon, CouponResponseModel.class));
    }

    @GetMapping("/{code}")
    public ResponseEntity<CouponResponseModel> getCouponByCode(@PathVariable("code") String code){

        log.info("Executing getCouponByCode() with code={}", code);
        CouponDto couponDto = couponService.getCoupon(code);
        return ResponseEntity.status(HttpStatus.OK).body(new ModelMapper().map(couponDto, CouponResponseModel.class));
    }
}
