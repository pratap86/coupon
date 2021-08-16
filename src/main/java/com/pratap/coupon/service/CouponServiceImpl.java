package com.pratap.coupon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratap.coupon.dto.CouponDto;
import com.pratap.coupon.entity.CouponEntity;
import com.pratap.coupon.exception.CouponNotFoundException;
import com.pratap.coupon.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

import static com.pratap.coupon.utils.CouponUtils.generateCouponId;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService{

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ObjectMapper jsonMapper;

    @Override
    public CouponDto create(CouponDto couponDto) throws JsonProcessingException {

        couponDto.setCouponId(generateCouponId(12));
        log.info("Executing create() with payload={}", jsonMapper.writeValueAsString(couponDto));
        CouponEntity savedCoupon = couponRepository.save(new ModelMapper().map(couponDto, CouponEntity.class));
        return new ModelMapper().map(savedCoupon, CouponDto.class);
    }

    @Override
    public CouponDto getCoupon(String code) {

        log.info("Executing getCoupon() with code={}", code);

        CouponEntity savedCoupon = couponRepository.findByCode(code);
        if (savedCoupon == null){
            log.info("No Coupon is associated with code={}", code);
            throw new CouponNotFoundException("No Coupon is associated with code= "+ code);
        }

        return new ModelMapper().map(savedCoupon, CouponDto.class);
    }

    @Override
    public List<CouponDto> getCoupons() {

        log.info("Executing getCoupons()");
        List<CouponEntity> couponEntities = couponRepository.findAll();
        return couponEntities.stream()
                .map(couponEntity -> new ModelMapper().map(couponEntity, CouponDto.class)).collect(Collectors.toList());
    }
}
