package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxApp;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/tx")
public class TxApi {

    @Autowired TxApp txApp;

    @PostMapping("save")
    public ResponseEntity<TxDto.Create>save(TxDto.Create dto){
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping ("find-sale-list-by-mem-no")
    public ResponseEntity<List<TxDto.Read>> findSaleListByMemNo(Principal principal){
        List<TxDto.Read> result = txApp.findSaleListByMemNo(principal.getName());
        return ResponseEntity.ok().body(result);
    }
    @GetMapping ("find-purchase-list-by-mem-no")
    public ResponseEntity<List<TxDto.Read>> findPurchaseListByMemNo(Principal principal){
        List<TxDto.Read> result = txApp.findPurchaseListByMemNo(principal.getName());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping ("find-by-id")
    public ResponseEntity<TxDto.Read> findById(Long txNo, Principal principal){
        TxDto.Read result = txApp.findById(txNo);
        return ResponseEntity.ok().body(result);
    }

}
