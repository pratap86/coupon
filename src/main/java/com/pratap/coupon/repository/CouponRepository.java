package com.pratap.coupon.repository;

import com.pratap.coupon.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    CouponEntity findByCode(String code);
}
