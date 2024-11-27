package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;

    private String name;
    private String email;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;


    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.created_at = user.getCreated_at();
        this.modified_at = user.getModified_at();
    }

    public UserResponseDto(Long id, String name, String email, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreated_at(),
                user.getModified_at()
        );
    }
}
