package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxApp;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/tx")
public class TxApi {
    @Autowired TxApp txApp;

    // 거래 저장
    @PostMapping("save")
    public ResponseEntity<Integer> save(TxDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(txApp.save(dto, principal.getName()));
    }

    // 판매 거래 조회
    @GetMapping("find-sale-list-by-mem-no")
    public ResponseEntity<List<TxDto.ReadList>> findSaleListByMemNo(TxDto.GetList dto, Principal principal) {
        return ResponseEntity.ok().body(txApp.findSaleListByMemNo(dto, principal.getName()));
    }

    // 구매 거래 조회
    @GetMapping("find-purchase-list-by-mem-no")
    public ResponseEntity<List<TxDto.ReadList>> findPurchaseListByMemNo(TxDto.GetList dto, Principal principal) {
        return ResponseEntity.ok().body(txApp.findPurchaseListByMemNo(dto, principal.getName()));
    }

    // 거래 조회
    @GetMapping("find-by-id")
    public ResponseEntity<TxDto.Read> findById(Long txNo) {
        return ResponseEntity.ok().body(txApp.findById(txNo));
    }
}
