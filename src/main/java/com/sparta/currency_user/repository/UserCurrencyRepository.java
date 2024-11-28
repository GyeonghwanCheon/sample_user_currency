package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {

    List<UserCurrency> findAllByUserId(Long userId);

}
