package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.ReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.security.Principal;

@RestController
@RequestMapping("api/v1/review")
public class ReviewApi {
    @Autowired ReviewApp reviewApp;
    @PostMapping("save")
    public ResponseEntity<Integer> save(Long reviewNo, Principal principal) {
        Integer result=reviewApp.save();
        return ResponseEntity.ok().body(1);
    }
    @PutMapping("update")
    public ResponseEntity<Integer> update(Long reviewNo, Principal principal) {
        Integer result=reviewApp.update();
        return ResponseEntity.ok().body(1);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long reviewNo, Principal principal) {
        Integer result=reviewApp.delete();
        return ResponseEntity.ok().body(1);
    }


    @GetMapping("find-by-review-no")
    public ResponseEntity<TxDto.Read> findByReviewNo(ReviewDto.Read dto, Principal principal){
        TxDto.Read result = reviewApp.findByReviewNo();
        return ResponseEntity.ok().body(null);
    }

}