package com.sparta.currency_user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ExchangeTotalResponseDto {

    //해당 고객이 수행한 환전 요청 데이터들의 총 row 수
    private Long count;

    //해당 고객이 환전을 요청한 총 금액
    private BigDecimal totalAmountInKrw;
}
