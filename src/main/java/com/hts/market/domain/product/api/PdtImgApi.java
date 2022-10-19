package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtImgApp;
import com.hts.market.domain.product.dto.PdtImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-img")
public class PdtImgApi {
    @Autowired

    private PdtImgApp pdtImgApp;

    // 이미지저장
//    @PostMapping("save-files")
//    public ResponseEntity<Integer> saveFiles(@Valid PdtImgDto.ListFile dto) throws IOException {
//        return ResponseEntity.ok().body(pdtImgApp.save(dto));
//    }
    // 이미지수정
    @PutMapping("update-files")
    public ResponseEntity<Integer> updateFile(@Valid PdtImgDto.ListFile dto) throws IOException{
        return ResponseEntity.ok().body(pdtImgApp.update(dto));
    }

    // 이미지 전체삭제
    @DeleteMapping("delete-all")
    public ResponseEntity<Integer> deleteAll(@NotNull Long pdtNo) throws IOException {
        return ResponseEntity.ok().body(pdtImgApp.deleteAll(pdtNo));
    }

    // 이미지 개별삭제
    @DeleteMapping("delete-by-img-no")
    public ResponseEntity<Integer> deleteByImgNo(@Valid PdtImgDto.Delete dto) throws IOException {
        return ResponseEntity.ok().body(pdtImgApp.deleteByImgNo(dto));
    }



}
