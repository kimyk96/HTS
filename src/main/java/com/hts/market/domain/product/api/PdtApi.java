package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.dto.PdtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt")
public class PdtApi {
    @Autowired
    private PdtApp pdtApp;

    // 상품등록
    @PreAuthorize("")
    @PostMapping(value = "/save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) {
        Integer result = pdtApp.save();
        return null;
    }
    // 상품수정
    @PutMapping(value = "/update")
    public ResponseEntity<Integer> update(@Valid PdtDto.Update dto, Principal principal){
        return null;
    }
   // 상품삭제
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Integer> delete(@NotNull Long pdtNo, Principal principal){
        return null;
    }
    // 키워드검색
    @GetMapping(value = "/find-by-keyword-like")
    public PdtDto.KeywordRead findByKeywordLike(@Valid PdtDto.KeywordRead dto){
        return null;
    }
    // 회원명 검색
    @GetMapping(value = "/find-by-mem-name-like")
    public String findBySellerLike(@NotEmpty String memName){
        return null;
    }
    // 회원별 상품목록보기
    @GetMapping(value = "/find-all-by-mem-no")
    public String findAllByMemNo(@NotNull long memNo, Principal principal){
        return null;
    }
}
