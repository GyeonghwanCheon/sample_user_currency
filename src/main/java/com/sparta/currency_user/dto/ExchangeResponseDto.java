package com.sparta.currency_user.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ExchangeResponseDto {

    // 환전 요청 id
    private Long id;

    // 사용자 이름
    private String userName;

    // 환전 통화 이름
    private String currencyName;

    // 환전 전 금액
    private BigDecimal amountInKrw;

    // 환전 후 금액
    private BigDecimal amountAfterExchange;

    // 상태
    private String status;


    public ExchangeResponseDto(Long id, String userName, String currencyName, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status) {
        this.id = id;
        this.userName = userName;
        this.currencyName = currencyName;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }
}
