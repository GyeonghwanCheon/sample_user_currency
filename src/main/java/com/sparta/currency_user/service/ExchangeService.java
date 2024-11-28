package com.sparta.currency_user.service;


import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserCurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final UserCurrencyRepository userCurrencyRepository;

    public ExchangeResponseDto exchangeCurrency(Long userId, Long currencyId, BigDecimal amountInKrw) {

        // 고객 확인
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("유저 ID를 찾을 수 없습니다."));

        // 통화 확인
        Currency currency = currencyRepository.findById(currencyId).orElseThrow(
                () -> new IllegalArgumentException("통화 ID를 찾을 수 없습니다."));


        BigDecimal exchangeRate = currency.getExchangeRate();

        BigDecimal exchangeAmount = amountInKrw.divide(exchangeRate, 2, BigDecimal.ROUND_HALF_UP);

        UserCurrency userCurrency = new UserCurrency();
        userCurrency.setUser(user);
        userCurrency.setCurrency(currency);
        userCurrency.setAmount_in_krw(amountInKrw);
        userCurrency.setAmount_after_exchange(exchangeAmount);
        userCurrency.setStatus("NORMAL");

        userCurrencyRepository.save(userCurrency);

        ExchangeResponseDto responseDto = new ExchangeResponseDto(
                user.getId(),
                user.getName(),
                currency.getCurrencyName(),
                userCurrency.getAmount_in_krw(),
                userCurrency.getAmount_after_exchange(),
                userCurrency.getStatus()
        );

        return responseDto;
    }
}
