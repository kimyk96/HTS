package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.TxApp;
import com.hts.market.domain.transaction.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/tx")
public class TxApi {

    @Autowired TxApp txApp;

    @PostMapping("/save")
    public ResponseEntity<Integer> save(TxDto.Create dto){
        Integer result = txApp.save(dto);
        return ResponseEntity.ok().body(1);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<Integer> delete(Long txNo){
        Integer result = txApp.delete();
        return null;
    }

    @GetMapping ("/find-all-by-mem-no")
    public ResponseEntity<List<TxDto.Read>> findAllByMemNo(){
        return null;
    }

    @GetMapping ("/find-by-id")
    public ResponseEntity<TxDto.Read> findById(){
        return null;
    }

}
