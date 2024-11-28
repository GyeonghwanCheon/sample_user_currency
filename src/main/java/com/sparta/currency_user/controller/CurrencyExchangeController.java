package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchanges")
public class CurrencyExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(@RequestBody ExchangeRequestDto requestDto) {

        ExchangeResponseDto responseDto = exchangeService.exchangeCurrency(requestDto.getUserId(), requestDto.getCurrencyId(), requestDto.getAmountInKrw());

        return ResponseEntity.ok(responseDto);

    }

}
