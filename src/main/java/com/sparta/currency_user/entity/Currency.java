package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "currency")
public class Currency extends BaseEntity{

    // 통화 고유 식별자 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 통화 이름
    private String currencyName;

    // 환율
    private BigDecimal exchangeRate;

    // 표시
    private String symbol;

    @OneToMany(mappedBy = "currency")
    private List<UserCurrency> userCurrencies = new ArrayList<>();

    public Currency(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public Currency() {}
}
