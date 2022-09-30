package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtFavoriteApp;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-favorite")
public class PdtFavoriteApi {
    @Autowired
    private PdtFavoriteApp pdtFavoriteApp;

    // 관심등록
    @PostMapping("save")
    public ResponseEntity<String> save(@Valid PdtFavoriteDto.Create dto, Principal principal){
        return null;
    }
    // 관심해제
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@Valid PdtFavoriteDto.Delete dto, Principal principal){
        return null;
    }
    // 관심목록읽기
    @GetMapping("/find-all-by-pdt-no")
    public ResponseEntity<Integer> findAllByPdtNo(@Valid PdtFavoriteDto.Page dto, Principal principal){
        return null;
    }
}
