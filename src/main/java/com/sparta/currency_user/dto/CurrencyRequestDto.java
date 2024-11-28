package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    // 통화 이름
    private String currencyName;

    // 환율
    private BigDecimal exchangeRate;

    // 화폐 기호
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}
