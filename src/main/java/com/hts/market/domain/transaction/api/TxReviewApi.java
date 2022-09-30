package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1/tx-review")
public class TxReviewApi {
    @Autowired TxReviewApp txReviewApp;

    @PostMapping("save")
    public ResponseEntity<Integer> save() {
        return null;
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete() {
        return null;
    }

    @GetMapping("find-all-by-mem-no")
    public ResponseEntity<List<ReviewDto.Read>> findAllByMemNo() {
        return null;
    }


}
