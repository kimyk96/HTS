package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxReviewApp;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("api/v1/tx-review")
public class TxReviewApi {
    @Autowired TxReviewApp txReviewApp;

    // 거래 리뷰 등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(TxReviewDto.SaveReview dto, Principal principal) {
        return ResponseEntity.ok().body(txReviewApp.save(dto, principal.getName()));
    }

    // 거래 리뷰 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long txNo, Principal principal) {
        Integer result = txReviewApp.delete(txNo, principal.getName());
        return ResponseEntity.ok().body(result);
    }

    // 거래 리뷰 불러오기
    @GetMapping("")
    public ResponseEntity<TxReviewDto.ReadList> findAllByTxNo(TxReviewDto.Read dto, Principal principal) {
        return ResponseEntity.ok().body(txReviewApp.findAllByTxNo(dto, principal.getName()));
    }
}
