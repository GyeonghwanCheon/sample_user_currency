package com.sparta.currency_user.service;


import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.ExchangeTotalResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserCurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final UserCurrencyRepository userCurrencyRepository;

    public ExchangeResponseDto exchangeCurrency(Long userid, Long currencyid, BigDecimal amountInKrw) {

        // 고객 확인
        User user = userRepository.findByUserIdOrElseThrow(userid);
        // 통화 확인
        Currency currency = currencyRepository.findByCurrencyIdOrElseThrow(currencyid);


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


    // 특정 고객 환불 요청 조회
    public List<ExchangeResponseDto> findByUserCurrency(Long userid) {
        // 고객 확인
        User user = userRepository.findByUserIdOrElseThrow(userid);

        // 고객의 모든 환불 요청 조회
        List<UserCurrency> userCurrencyList = userCurrencyRepository.findAllByUserId(userid);

        // 데이터 변환
        List<ExchangeResponseDto> exchangeResponseDtoList = new ArrayList<>();


        for (UserCurrency userCurrency : userCurrencyList) {
            ExchangeResponseDto responseDto = new ExchangeResponseDto(
                    user.getId(),
                    user.getName(),
                    userCurrency.getCurrency().getCurrencyName(),
                    userCurrency.getAmount_in_krw(),
                    userCurrency.getAmount_after_exchange(),
                    userCurrency.getStatus()
            );

            exchangeResponseDtoList.add(responseDto);
        }

        return exchangeResponseDtoList;
    }

    // 특정 환전 요청 상태를 취소로 변경
    public void updateStatus(Long userCurrencyid) {
        UserCurrency userCurrency = userCurrencyRepository.findByUserCurrencyIdOrElseThrow(userCurrencyid);

        if("NORMAL".equals(userCurrency.getStatus())) {
            userCurrency.setStatus("CANCELED");
        } else if("CANCELED".equals(userCurrency.getStatus())) {
            userCurrency.setStatus("NORMAL");
        }


        userCurrencyRepository.save(userCurrency);
    }

    // 고객의 모든 환전 요청을 그룹화하여 조회
    public ExchangeTotalResponseDto totalExchange(Long userid) {

        User user = userRepository.findByUserIdOrElseThrow(userid);

        ExchangeTotalResponseDto responseDto = userCurrencyRepository.findByTotalExchangeUserId(userid);

        return responseDto;

    }
}
