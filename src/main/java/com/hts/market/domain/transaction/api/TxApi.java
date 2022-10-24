package com.hts.market.domain.transaction.api;

import com.hts.market.domain.product.dto.PdtDto;
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
    public ResponseEntity<Integer>save(TxDto.Create dto, Principal principal){
        return ResponseEntity.ok().body(txApp.save(dto, principal.getName()));
    }
    @GetMapping ("find-sale-list-by-mem-no")
    public ResponseEntity<List<TxDto.ReadList>> findSaleListByMemNo(TxDto.GetList dto, Principal principal){
        return ResponseEntity.ok().body(txApp.findSaleListByMemNo(dto, principal.getName()));
    }
    @GetMapping ("find-purchase-list-by-mem-no")
    public ResponseEntity<List<TxDto.ReadList>> findPurchaseListByMemNo(TxDto.GetList dto, Principal principal){
        return ResponseEntity.ok().body(txApp.findPurchaseListByMemNo(dto, principal.getName()));
    }
    @GetMapping ("find-by-id")
    public ResponseEntity<TxDto.Read> findById(Long txNo){
        return ResponseEntity.ok().body(txApp.findById(txNo));
    }

}
