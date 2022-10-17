package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtImgApp;
import com.hts.market.domain.product.dto.PdtImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-img")
public class PdtImgApi {
    @Autowired

    private PdtImgApp pdtImgApp;

    // 이미지저장
    @PostMapping("save-files")
    public ResponseEntity<Integer> saveFiles(@Valid PdtImgDto.ListFile dto, Principal principal) throws IOException {
        return ResponseEntity.ok().body(pdtImgApp.save(dto));
    }
    // 이미지수정
    @PutMapping("update-file")
    public ResponseEntity<Integer> updateFile(@Valid PdtImgDto.UpdateFile dto, Principal principal) throws IOException{
        return ResponseEntity.ok().body(pdtImgApp.update(dto));
    }

    // 이미지 개별삭제
    @DeleteMapping("delete-by-img-no")
    public ResponseEntity<Integer> deleteByImgNo(@Valid PdtImgDto.Delete dto, Principal principal){
        return ResponseEntity.ok().body(pdtImgApp.deleteByImgNo(dto));
    }

    // 이미지 전체삭제
    @DeleteMapping("delete-all")
    public ResponseEntity<Integer> deleteAll(@Valid PdtImgDto.Delete dto, Principal principal){
        return ResponseEntity.ok().body(pdtImgApp.deleteAll(dto));
    }

}
