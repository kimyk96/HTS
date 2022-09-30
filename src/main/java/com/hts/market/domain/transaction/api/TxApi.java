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

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@Valid TxDto.Create dto, Principal principal){
        Integer result = txApp.save();
        return ResponseEntity.ok().body(1);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<Integer> delete(Long txNo, Principal principal){
        Integer result = txApp.delete();
        return ResponseEntity.ok().body(1);
    }

    @GetMapping ("/find-all-by-mem-no")
    public ResponseEntity<List<TxDto.Read>> findAllByMemNo(Long memNo, Principal principal){
        List<TxDto.Read> result = txApp.findAllByMemNo();
        return ResponseEntity.ok().body(null);
    }

    @GetMapping ("/find-by-id")
    public ResponseEntity<TxDto.Read> findById(Long txNo, Principal principal){
        TxDto.Read result = txApp.findById();
        return ResponseEntity.ok().body(null);
    }

}
