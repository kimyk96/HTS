package com.hts.market.domain.transaction.api.advice;

import com.hts.market.domain.transaction.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TxApiAdvice {
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<String> transactionNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("거래내역을 찾을 수 없습니다.");
    }
}
