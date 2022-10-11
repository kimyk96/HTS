package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtRptApp;
import com.hts.market.domain.product.dto.PdtRptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-rpt")
public class PdtRptApi {
    @Autowired
    private PdtRptApp pdtRptApp;

    // 신고등록
    @PostMapping("save")
    private ResponseEntity<Integer> save(@Valid PdtRptDto.Create dto, Principal principal){
        return null;
    }
    // 신거읽기
    @GetMapping("read")
    private ResponseEntity<Integer> read(@Valid PdtRptDto.Read dto, Principal principal){
        return null;
    }

    // 신고
}
