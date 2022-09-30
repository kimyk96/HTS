package com.hts.market.domain.transection.api;

import com.hts.market.domain.transection.app.TxReviewApp;
import com.hts.market.domain.transection.dto.TxReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tx-review")
public class TxReviewApi {
    @Autowired TxReviewApp txReviewApp;
    @PostMapping("/save")
    public ResponseEntity<Integer>save(){
        return null;
        }
    @DeleteMapping("/delete")
    public ResponseEntity<Integer>delete(){
        return null;
    }
    @GetMapping("/find-all-by-mem-no")
    public ResponseEntity<List<TxReviewDto>>findAllByMemNo(){
        return null;
    }


}
