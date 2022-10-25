package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemRptApp;
import com.hts.market.domain.member.dto.MemRptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/mem-rpt")
public class MemRptApi {
    @Autowired MemRptApp memRptApp;

    // 회원 신고 
    @PostMapping("save")
    public ResponseEntity<Integer> save(MemRptDto.Create dto) {
        return ResponseEntity.ok().body(memRptApp.save(dto));
    }
}
