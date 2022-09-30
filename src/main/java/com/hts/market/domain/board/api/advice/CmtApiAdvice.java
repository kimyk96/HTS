package com.hts.market.domain.board.api.advice;


import com.hts.market.domain.board.exception.BoardNotFoundException;
import com.hts.market.domain.board.exception.CheckCommentWriterException;
import com.hts.market.domain.board.exception.InputCommentContentMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CmtApiAdvice {
    @ExceptionHandler(InputCommentContentMismatchException.class)
    public ResponseEntity<String> InputCommentContentMismatchExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("댓글 작성제한 초과(미만)");
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<String> BoardNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 삭제된 게시물입니다");
    }

    @ExceptionHandler(CheckCommentWriterException.class)
    public ResponseEntity<String> CheckCommentWriterExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("작성자만 수정(삭제)가능합니다");
    }
}
