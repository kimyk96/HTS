package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtCateApp;
import com.hts.market.domain.product.dto.PdtCateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-cate")
public class PdtCateApi {
    @Autowired private PdtCateApp pdtCateApp;
//    @PostMapping("save")
//    public ResponseEntity<Integer> save(PdtCateDto.Create dto){
//        return ResponseEntity.ok().body(pdtCateApp.save(dto));
//    }
    // 카테고리 목록
    @GetMapping("find-all")
    public ResponseEntity<List<PdtCateDto.Read>> findAll() {
        return ResponseEntity.ok().body(pdtCateApp.findAll());
    }

}
