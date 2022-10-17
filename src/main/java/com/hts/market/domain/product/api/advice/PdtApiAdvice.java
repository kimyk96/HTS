package com.hts.market.domain.product.api.advice;

import com.hts.market.domain.product.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class PdtApiAdvice {
    @ExceptionHandler(ProductUpdateFailException.class)
    public ResponseEntity<String> productUpdateFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("판매글을 수정할 수 없습니다");
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("판매글을 찾을 수 없습니다");
    }
    @ExceptionHandler(KeywordNotFoundException.class)
    public ResponseEntity<String> keywordNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당 키위드를 찾을 수 없습니다");
    }
    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<String> sellerNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당 작성자를 찾을 수 없습니다");
    }

    // pdtCateApiAdvice
    @ExceptionHandler(ProductCategoryNotFoundException.class)
    public ResponseEntity<String > productCategoryNotFoundException(){
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("해당 카테고리를 찾을 수 없습니다");
    }

    // pdtFavoriteAdvice
    @ExceptionHandler(ProductFavoriteNotFoundException.class)
    public ResponseEntity<String> productFavoriteNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("관심상픔을 찾을 수 없습니다");
    }

    // pdtImgAdvice
    @ExceptionHandler(ProductImageNotFoundException.class)
    public ResponseEntity<String> productImageNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미지를 찾을 수 없습니다");
    }
    @ExceptionHandler(ProductImageSaveFailException.class)
    public ResponseEntity<String> productImageSaveFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미지를 저장할 수 없습니다");
    }

    // pdtRptAdvice
    @ExceptionHandler(ProductReportSaveExhaustionException.class)
    public ResponseEntity<String> productReportSaveExhaustionException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("일일 신고횟수가 소진되었습니다");
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindExceptionHandler(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("필수입력 값이 없습니다");
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationExceptionHandler(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("필수입력 값이 없습니다");
    }
    @ExceptionHandler(ProductDeleteFailException.class)
    public ResponseEntity<String> productDeleteFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("상품삭제에 실패했습니다");
    }
    @ExceptionHandler(ReportSaveFailException.class)
    public ResponseEntity<String > reportSaveFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당상품을 이미 신고하셨습니다");
    }
}
