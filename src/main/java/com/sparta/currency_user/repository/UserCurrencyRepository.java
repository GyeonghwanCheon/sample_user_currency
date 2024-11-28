package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.error.errorcode.ErrorCode;
import com.sparta.currency_user.error.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {

    List<UserCurrency> findAllByUserId(Long userId);

    // 고객 조회 검증
    default UserCurrency findByUserCurrencyIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER_CERRENCY));
    }

}
