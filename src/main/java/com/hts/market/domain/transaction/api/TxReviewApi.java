package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxReviewApp;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
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
    public ResponseEntity<Integer> save(@Valid TxReviewDto.Create dto, Principal principal, TxDto.Read dto2) {
        return ResponseEntity.ok().body(txReviewApp.save(dto, principal.getName(),dto2));
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long TxReviewNo, Principal principal) {
        Integer result=txReviewApp.delete(TxReviewNo);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("find-buyer-by-tx-review-no")
    public ResponseEntity<List<TxReviewDto.Read>>  findBuyerByTxReviewNo(TxReviewDto.Read dto) {
        return ResponseEntity.ok().body(txReviewApp.findBuyerByTxReviewNo(dto));
    }
    @GetMapping("find-seller-by-tx-review-no")
    public ResponseEntity<List<TxReviewDto.Read>>  findSellerByTxReviewNo(TxReviewDto.Read dto) {
        return ResponseEntity.ok().body(txReviewApp. findSellerByTxReviewNo(dto));


    }
}
