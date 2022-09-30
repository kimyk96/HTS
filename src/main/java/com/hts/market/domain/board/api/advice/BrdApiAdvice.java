package com.hts.market.domain.board.api.advice;

import com.hts.market.domain.board.exception.ReportMemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BrdApiAdvice {
    @ExceptionHandler(ReportMemberException.class)
    public ResponseEntity<String> reportMemberExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("신고당해 차단된 회원 글쓰기제한");
    }
}
