package com.hts.market.domain.transection.api;

import com.hts.market.domain.transection.app.TxApp;
import com.hts.market.domain.transection.dto.TxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tx")
public class TxApi {
    @Autowired TxApp txApp;
    @PostMapping("/save")
    public ResponseEntity<Integer> save(){
        return null;
    }

    @DeleteMapping ("/delete")
    public ResponseEntity<Integer> dalete(){
        return null;
    }

    @GetMapping ("/find-all-by-mem-no")
    public ResponseEntity<List<TxDto.Read>> findAllByMemNo(){
        return null;
    }

    @GetMapping ("/find-all-by-id")
    public ResponseEntity<TxDto.Read> findAllById(){
        return null;
    }

}
