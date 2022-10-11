package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/pdt")
public class PdtApi {
    @Autowired
    private PdtApp pdtApp;
    // 상품등록
//    @PreAuthorize("")
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) {
        return null;
    }

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
    @GetMapping("find-by-pdt-no")
    public ResponseEntity<PdtDto.Read> findByPdtNo(@NotNull Long pdtNo, Principal principal){
        PdtDto.Read result= pdtApp.findByPdtNo(pdtNo).orElseThrow(()->new ProductNotFoundException());
        return ResponseEntity.ok().body(result);
    }

    // 제목+내용, 카테고리 검색
    @GetMapping("find-by-search")
    public ResponseEntity<PdtDto.SearchData> findByKeywordLike(@Valid PdtDto.SearchData dto, Principal principal) {
        return null;
    }

    // 판매자명 검색
    @GetMapping("find-by-pdt-seller-no-like")
    public ResponseEntity<Integer> findBySellerLike(@NotEmpty Long pdtSellerNo, Principal principal) {
        return null;
    }

    // 회원별(지정지역) 상품목록보기
    @GetMapping("find-all-by-pdt-address-no")
    public ResponseEntity<List<PdtDto.ReadList>> findAllByAddressNo(@Valid  PdtDto.AddressData dto, Principal principal, BindingResult bindingResult) {
        return ResponseEntity.ok().body(pdtApp.findAllByPdtAddress(dto));
    }




}
