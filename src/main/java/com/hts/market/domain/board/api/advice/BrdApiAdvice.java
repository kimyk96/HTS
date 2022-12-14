package com.hts.market.domain.board.api.advice;

import com.hts.market.domain.board.exception.*;
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

    @ExceptionHandler(InputContentMismatchException.class)
    public ResponseEntity<String> inputContentMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("지정된 글자수 초과,미만");
    }

    @ExceptionHandler(InputTitleMismatchException.class)
    public ResponseEntity<String> inputTitleMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("지정된 글자수 초과,미만(제목)");
    }

    @ExceptionHandler(InputCateMismatchException.class)
    public ResponseEntity<String> inputCateMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("카테고리 안넣으셨슴다");
    }

    @ExceptionHandler(BlockMemberException.class)
    public ResponseEntity<String> blockMemberExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("차단한 사용자 임다");
    }

    @ExceptionHandler(UpdateTitleMismatchException.class)
    public ResponseEntity<String> updateTitleMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("지정 글자수 초과(미만)입니다");
    }

    @ExceptionHandler(UpdateContentMismatchException.class)
    public ResponseEntity<String> updateContentMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("지정 글자수 초과(미만)입니다");
    }

    @ExceptionHandler(checkWriterException.class)
    public ResponseEntity<String> checkWriterExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("작성자만 수정(삭제)가능합니다");
    }

    @ExceptionHandler(ImgFileNotFoundException.class)
    public ResponseEntity<String> imgFileNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미지만 첨부 가능합니다");
    }

    @ExceptionHandler(ReportCountException.class)
    public ResponseEntity<String> reportCountExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 신고한 게시물 입니다");
    }
}
