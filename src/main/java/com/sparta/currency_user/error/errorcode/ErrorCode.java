package com.sparta.currency_user.error.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    // 404 NOT_FOUND : 정보를 찾을 수 없음
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "입력한 유저 ID를 찾을 수 없습니다."),
    NOT_FOUND_CURRENCY(HttpStatus.NOT_FOUND, "입력한 통화 ID를 찾을 수 없습니다."),
    NOT_FOUND_USER_CERRENCY(HttpStatus.NOT_FOUND, "입력한 환불 요청 정보를 찾을 수 없습니다.")


    ;


    private final HttpStatus httpStatus;
    private final String detail;
}
