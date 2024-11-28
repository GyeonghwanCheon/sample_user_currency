package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.ExchangeTotalResponseDto;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.error.errorcode.ErrorCode;
import com.sparta.currency_user.error.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {

    List<UserCurrency> findAllByUserId(Long userId);

    // 고객 조회 검증
    default UserCurrency findByUserCurrencyIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER_CERRENCY));
    }


    // 고객의 모든 환전 요청을 그룹화하여 조회 쿼리문
    @Query("SELECT new com.sparta.currency_user.dto.ExchangeTotalResponseDto(COUNT(uc), SUM(uc.amount_in_krw))" +
            "FROM UserCurrency uc " +
            "WHERE uc.user.id = :userid " +
            "GROUP BY uc.user.id"
    )
    ExchangeTotalResponseDto findByTotalExchangeUserId(@Param("userid") Long userid);
    //@Param : 순서 상관없이 입력해도 데이터를 매핑하기 위해서 사용.
}
