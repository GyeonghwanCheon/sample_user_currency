package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "user_currency")
public class UserCurrency extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "to_currency_id")
    private Currency currency;

    // 환전 전 금액
    private BigDecimal amount_in_krw;

    // 환전 후 금액
    private BigDecimal amount_after_exchange;

    // 상태
    private String status;


    public UserCurrency(BigDecimal amount_in_krw, BigDecimal amount_after_exchange, String status) {
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.status = status;
    }

    // 기본 생성자
    public UserCurrency() {}
}
