package com.sparta.currency_user.entity;

import jakarta.persistence.*;

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

    private Double amount_in_krw;
    private Double amount_after_exchange;
    private String status;

    public UserCurrency(Double amount_in_krw, Double amount_after_exchange, String status) {
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.status = status;
    }

    // 기본 생성자
    public UserCurrency() {}
}
