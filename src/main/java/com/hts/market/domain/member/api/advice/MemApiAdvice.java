package com.hts.market.domain.member.api.advice;

import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemApiAdvice {
    @ExceptionHandler(MemberAlreadyExsistException.class)
    public ResponseEntity<String> memberAlreadyExsistExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 회원입니다. 로그인을 진행해주세요");
    }
}
