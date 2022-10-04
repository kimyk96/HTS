package com.hts.market.domain.member.exception;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class KakaoMemberAlreadyExsistException extends RuntimeException{
    // 유저명
    @Getter
    private String username;

    public KakaoMemberAlreadyExsistException(String username){
        this.username = username;
    }
}
