package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1/tx-review")
public class TxReviewApi {
    @Autowired TxReviewApp txReviewApp;

    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid TxReviewDto.Create dto, Principal principal) {
        Integer result=txReviewApp.save();
        return ResponseEntity.ok().body(1);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long TxReviewNo, Principal principal) {
        Integer result=txReviewApp.delete();
        return ResponseEntity.ok().body(1);
    }

    @GetMapping("find-all-by-mem-no")
    public ResponseEntity<List<ReviewDto.Read>> findAllByMemNo(Long memNo, Principal principal) {
        List<ReviewDto.Read> result = txReviewApp.findAllByMemNo();
        return ResponseEntity.ok().body(null);
    }


}
