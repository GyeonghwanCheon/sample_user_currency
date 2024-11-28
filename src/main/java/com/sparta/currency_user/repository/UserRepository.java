package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.error.errorcode.ErrorCode;
import com.sparta.currency_user.error.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 고객 조회 검증
    default User findByUserIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER));
    }

}
