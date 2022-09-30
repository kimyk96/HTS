package com.hts.market.domain.board.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdRptApi {


    // 댓글 작성
    @PostMapping("rpt-save")
    public ResponseEntity<Integer> save(){
        return null;
    }
}
