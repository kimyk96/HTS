package com.hts.market.domain.product.api.advice;

import com.hts.market.domain.product.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PdtApiAdvice {
    // PdtApiAdvice
    @ExceptionHandler(KeywordNotFoundException.class)
    public ResponseEntity<String> ProductSaveFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("판매글을 작성할 수 없습니다");
    }
    @ExceptionHandler(ProductUpdateFailException.class)
    public ResponseEntity<String> ProductUpdateFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("판매글을 수정할 수 없습니다");
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> ProductNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("판매글을 찾을 수 없습니다");
    }
    @ExceptionHandler(KeywordNotFoundException.class)
    public ResponseEntity<String> KeywordNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당 키위드를 찾을 수 없습니다");
    }
    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<String> SellerNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당 작성자를 찾을 수 없습니다");
    }

    // pdtCateApiAdvice
    @ExceptionHandler(ProductCategoryNotFoundException.class)
    public ResponseEntity<String > ProductCategoryNotFoundException(){
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("해당 카테고리를 찾을 수 없습니다");
    }

    // pdtFavoriteAdvice
    @ExceptionHandler(ProductFavoriteNotFoundException.class)
    public ResponseEntity<String> ProductFavoriteNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("관심상픔을 찾을 수 없습니다");
    }

    // pdtImgAdvice
    @ExceptionHandler(ProductImageNotFoundException.class)
    public ResponseEntity<String> ProductImageNotFoundException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미지를 찾을 수 없습니다");
    }
    @ExceptionHandler(ProductImageSaveFailException.class)
    public ResponseEntity<String> ProductImageSaveFailException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미지를 저장할 수 없습니다");
    }

    // pdtRptAdvice
    @ExceptionHandler(ProductReportSaveExhaustionException.class)
    public ResponseEntity<String> ProductReportSaveExhaustionException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("일일 신고횟수가 소진되었습니다");
    }
}