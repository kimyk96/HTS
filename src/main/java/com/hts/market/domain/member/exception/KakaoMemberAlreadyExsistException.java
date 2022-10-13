package com.hts.market.domain.member.exception;

import com.hts.market.domain.member.entity.MemEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class KakaoMemberAlreadyExsistException extends RuntimeException{
    // 유저명
    @Getter
    private MemEntity member;

    public KakaoMemberAlreadyExsistException(MemEntity member){
        this.member = member;
    }
}
