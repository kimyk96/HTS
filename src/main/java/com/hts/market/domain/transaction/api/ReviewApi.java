package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.ReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewApi {
    @Autowired ReviewApp reviewApp;

    // 리뷰 조회
    @GetMapping("")
    public ResponseEntity<List<ReviewDto.Read>> findByReviewNo() {
        return ResponseEntity.ok().body(reviewApp.findByReviewNo());
    }
}