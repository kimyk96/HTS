package com.hts.market.domain.transaction.api.advice;

import com.hts.market.domain.transaction.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TxApiAdvice {
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<String> transactionNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("거래 내역을 찾을 수 없습니다.");
    }
    @ExceptionHandler(TransactionSaveFailException.class)
    public ResponseEntity<String> transactionSaveFailExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("거래 생성에 실패하였습니다.");
    }

    @ExceptionHandler(TransactionReviewNotFoundException.class)
    public ResponseEntity<String> transactionReviewNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("거래 후기를 찾을 수 없습니다.");
    }

    @ExceptionHandler(ReviewSaveFailExcetion.class)
    public ResponseEntity<String> reviewSaveFailExcetionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("리뷰 작성에 실패하였습니다.");
    }

    @ExceptionHandler(ReviewUpdateFailExcetion.class)
    public ResponseEntity<String> reviewUpdateFailExcetionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("리뷰 수정에 실패하였습니다.");
    }
}
