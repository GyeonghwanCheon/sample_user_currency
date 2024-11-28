package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @Size(min = 1, max = 18, message = "이름의 글자 수는 1~20개 사이여야 합니다.")
    private String name;

    @Size(min = 1, max = 25, message = "이메일의 글자 수는 1~25개 사이야야 합니다.")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
