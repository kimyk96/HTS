package com.hts.market.domain.chat.api.adivce;


import com.hts.market.domain.chat.exception.NonUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChatApiAdivce {
    @ExceptionHandler(NonUserException.class)
    public ResponseEntity<String> nonUserExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("회원 탈퇴한 유저입니다.");
    }
}