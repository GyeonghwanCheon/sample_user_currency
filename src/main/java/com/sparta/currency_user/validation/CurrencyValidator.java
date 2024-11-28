package com.sparta.currency_user.validation;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyValidator {

    private final CurrencyRepository currencyRepository;

    // 스프링 구동 시 실행
    @PostConstruct
    public void validateExchangeRate() {
        log.info("통화 테이블의 환율을 검증합니다.");

        // 통화 테이블의 모든 데이터 조회
        List<Currency> currencies = currencyRepository.findAll();

        for (Currency currency : currencies) {
            BigDecimal rate = currency.getExchangeRate();

            // 환율 검증 조건
            if (rate.compareTo(BigDecimal.ZERO.setScale(2)) <= 0) {
                log.warn("유효하지 않은 환율 발견: 통화 ID={}, 이름={}, 환율={}",
                        currency.getId(), currency.getCurrencyName(), rate);
            }
        }

        log.info("환율 검증 완료.");
    }
}
