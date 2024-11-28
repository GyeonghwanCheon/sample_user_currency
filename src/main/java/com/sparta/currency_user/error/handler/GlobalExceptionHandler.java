package com.sparta.currency_user.error.handler;


import com.sparta.currency_user.error.exception.CustomException;
import com.sparta.currency_user.error.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { CustomException.class })
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ce) {
        return ErrorResponse.toResponseEntity(ce.getErrorCode());
    }

}
