package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtImgApp;
import com.hts.market.domain.product.dto.PdtImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-img")
public class PdtImgApi {
    @Autowired
    private PdtImgApp pdtImgApp;

    // 이미지저장
    @PostMapping("save")
    private ResponseEntity<Integer> save(@Valid PdtImgDto.Create dto, Principal principal){
        return null;
    }
    // 이미지수정
    @PutMapping("update")
    private ResponseEntity<Integer> update(@Valid PdtImgDto.Update dto, Principal principal){
        return null;
    }
    // 대표이미지 보기
//    @GetMapping()
//    public  ResponseEntity<PdtImgDto.Read> readByMain(){
//        return null;
//    }
//    // 이미지목록 보기
//    @GetMapping()
//    public  ResponseEntity<PdtImgDto.Read> readByAll(){
//        return null;
//    }
//    // 이미지삭제
    @DeleteMapping("delete")
    private ResponseEntity<Integer> delete(@Valid PdtImgDto.Delete dto, Principal principal){
        return null;
    }
}
