package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.dto.PdtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/pdt")
@Secured("ROLE_USER")
public class PdtApi {
    @Autowired
    private PdtApp pdtApp;
    // 상품등록
//    @PreAuthorize("")
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(pdtApp.save(dto, principal.getName()));
    }

    // 상품수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid PdtDto.Update dto, Principal principal) {
        return ResponseEntity.ok().body(pdtApp.update(dto));
    }

    // 상품삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid PdtDto.Delete dto, Principal principal, BindingResult bindingResult) {
       return ResponseEntity.ok().body(pdtApp.delete(dto));
    }

    // 판맥글 보기
    // 현재 문제 이미지가 2개 이상들어간 글을 조회할 수 없음 이미지 테이블 제외해야할 것 같음
    @GetMapping("find-by-pdt-no")
    public ResponseEntity<PdtDto.Detail> findByPdtNo(@NotNull Long pdtNo, Principal principal){
        PdtDto.Detail result = pdtApp.findByPdtNo(pdtNo, principal.getName());
        return ResponseEntity.ok().body(result);
    }

    // 회원별(지정지역) 상품목록보기
    @GetMapping("find-all-by-pdt-address-no")
    public ResponseEntity<List<PdtDto.ReadList>> findAllByAddressNo(@Valid  PdtDto.AddressData dto, Principal principal, BindingResult bindingResult) {
        return ResponseEntity.ok().body(pdtApp.findAllByPdtAddress(dto));
    }

    // 제목+내용, 카테고리 검색
    @GetMapping("find-by-keyword-like")
    public ResponseEntity<List<PdtDto.ReadList>> findByKeywordLike(@Valid PdtDto.SearchData dto, Principal principal) {
        return ResponseEntity.ok().body(pdtApp.findByPdtKeywordLike(dto));
    }

    // 판매자 찾기
    @GetMapping("find-pdt-seller-no")
    public ResponseEntity<Long> findPdtSellerNo(@NotNull Long pdtSellerNo, Principal principal){
        return ResponseEntity.ok().body(pdtApp.findPdtSellerNo(pdtSellerNo));
    }


}
