package com.sparta.currency_user.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ExchangeRequestDto {

    // 고객 id
    private Long userId;

    // 환전 대상 통화 id
    private Long currencyId;

    // 환전 전 금액
    private BigDecimal amountInKrw;

}
