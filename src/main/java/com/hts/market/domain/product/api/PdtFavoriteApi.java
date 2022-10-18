package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtFavoriteApp;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-favorite")
public class PdtFavoriteApi {
    @Autowired
    private PdtFavoriteApp pdtFavoriteApp;

    // 관심등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtFavoriteDto.Create dto, Principal principal){
        return ResponseEntity.ok().body(pdtFavoriteApp.save(dto, principal.getName()));
    }
    // 관심해제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid PdtFavoriteDto.Delete dto, Principal principal){
        return ResponseEntity.ok().body(pdtFavoriteApp.delete(dto));
    }
    // 관심목록
    @GetMapping("/find-all-of-favorite-list")
    public ResponseEntity<List<PdtFavoriteDto.ReadList>> findAllOfFavoriteList(Principal principal){
        return ResponseEntity.ok().body(pdtFavoriteApp.findAllOfFavoriteList(principal.getName()));
    }
}
