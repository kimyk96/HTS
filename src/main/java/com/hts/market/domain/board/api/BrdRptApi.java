package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdRptApp;
import com.hts.market.domain.board.dto.BrdRptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd-rpt")
public class BrdRptApi {
    @Autowired
    BrdRptApp brdRptApp;


    // 댓글 작성
    @PostMapping("rpt-save")
    public ResponseEntity<Integer> save(BrdRptDto.Create dto){
        return null;
    }
}
