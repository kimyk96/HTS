package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.dto.PdtDto;
import io.swagger.models.auth.In;
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
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) {return null;}

    // 상품수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid PdtDto.Update dto, Principal principal) {
        return null;
    }

    // 상품삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@NotNull Long pdtNo, Principal principal) {
        return null;
    }

    // 판맥글 보기
    @GetMapping("find-By-pdt-no")
    public ResponseEntity<Integer> findByPdtNo(@Valid PdtDto.Read dto, Principal principal){
        return null;
    }

    // 키워드 검색
    @GetMapping("find-by-keyword-like")
    public ResponseEntity<PdtDto.KeywordSearch> findByKeywordLike(@Valid PdtDto.KeywordSearch dto, Principal principal) {
        return null;
    }

    // 판매자명 검색
    @GetMapping("find-by-pdt-seller-no-like")
    public ResponseEntity<Integer> findBySellerLike(@NotEmpty Long pdtSellerNo, Principal principal) {
        return null;
    }

    // 회원별(지정지역) 상품목록보기
    @GetMapping("find-all-by-pdt-address-no")
    public ResponseEntity<Integer> findAllByMemNo(@NotNull Long memNo, Principal principal ) {
        return null;
    }

    // 카테고리별 상품목록
    @GetMapping("find-by-pdt-cate-no")
    public ResponseEntity<Integer> findByPdtCateNo(@NotNull Long cateNo, Principal principal ){
        return null;
    }


}
