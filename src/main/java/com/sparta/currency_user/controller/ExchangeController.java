package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.ExchangeTotalResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    // 환전 요청
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(@RequestBody ExchangeRequestDto requestDto) {

        ExchangeResponseDto responseDto = exchangeService.exchangeCurrency(requestDto.getUserid(), requestDto.getCurrencyid(), requestDto.getAmountInKrw());

        return ResponseEntity.ok(responseDto);

    }

    // 특정 고객 환전 요청 조회
    @GetMapping("/{userid}")
    public ResponseEntity<List<ExchangeResponseDto>> findByUserCurrency(@PathVariable Long userid) {
        List<ExchangeResponseDto> responseDto = exchangeService.findByUserCurrency(userid);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    // 특정 환전 요청 상태를 취소로 변경
    @PatchMapping("/{userCurrencyid}")
    public ResponseEntity<String> updateStatus(@PathVariable Long userCurrencyid) {
        exchangeService.updateStatus(userCurrencyid);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // 고객의 모든 환전 요청을 그룹화하여 조회
    @GetMapping("/sumExchange/{userid}")
    public ResponseEntity<ExchangeTotalResponseDto> totalExchange (@PathVariable Long userid) {
        ExchangeTotalResponseDto total = exchangeService.totalExchange(userid);

        return ResponseEntity.ok(total);
    }


}
