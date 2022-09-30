package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtCateApp;
import com.hts.market.domain.product.dto.PdtCateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-cate")
public class PdtCateApi {
    @Autowired
    private PdtCateApp pdtCateApp;

    // 카테고리 목록
    @GetMapping("find-all")
    public ResponseEntity<Integer> findAll(@Valid PdtCateDto.Read dto, Principal principal){
        return null;
    }

}
