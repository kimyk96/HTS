package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.ReviewApp;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/review")
public class ReviewApi {
    @Autowired ReviewApp reviewApp;
    @PostMapping("save")
    public ResponseEntity<Integer> save() {
        Integer result=ReviewApp.save();
        return ResponseEntity.ok().body(1);
    }
    @PutMapping("update")
    public ResponseEntity<Integer> update() {
        Integer result=ReviewApp.update();
        return ResponseEntity.ok().body(1);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete() {
        Integer result=ReviewApp.delete();
        return ResponseEntity.ok().body(1);
    }


    @GetMapping("/find-by-review-no")
    public ResponseEntity<TxDto.Read> findByReviewNo(){
        TxDto.Read result = ReviewApp.findByReviewNo();
        return ResponseEntity.ok().body(null);
    }

}