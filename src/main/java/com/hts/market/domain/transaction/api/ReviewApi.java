package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.ReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewApi {
    @Autowired ReviewApp reviewApp;

    @GetMapping("find-by-review-no")
    public ResponseEntity<List<ReviewDto.Read>> findByReviewNo(Long reviewNo){
        List<ReviewDto.Read> result = reviewApp.findByReviewNo(reviewNo);
        return ResponseEntity.ok().body(result);
    }

}