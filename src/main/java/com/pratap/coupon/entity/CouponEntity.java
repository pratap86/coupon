package com.pratap.coupon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "coupon")
public class CouponEntity implements Serializable {

    private static final long serialVersionUID = 5282616486376636403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    private Date expDate;
    private String couponId;
}
