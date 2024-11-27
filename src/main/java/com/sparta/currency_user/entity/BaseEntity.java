package com.sparta.currency_user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {


    // 생성날짜
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created_at;

    // 수정날짜
    @LastModifiedDate
    private LocalDateTime modified_at;

}
