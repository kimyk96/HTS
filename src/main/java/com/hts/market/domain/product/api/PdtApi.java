package com.hts.market.domain.product.api;

import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.app.PdtFavoriteApp;
import com.hts.market.domain.product.app.PdtImgApp;
import com.hts.market.domain.product.app.PdtRptApp;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.dto.PdtImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/pdt")
public class PdtApi {
    @Autowired
    private PdtApp pdtApp;
    @Autowired
    private PdtImgApp pdtImgApp;
    @Autowired
    private PdtFavoriteApp pdtFavoriteApp;
    @Autowired
    private PdtRptApp pdtRptApp;
    @Autowired
    private MemRepo memRepo;

    // 상품 등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) throws IOException {
        pdtApp.save(dto, principal.getName());
        pdtImgApp.save(PdtImgDto.ListFile.builder().pdtNo(dto.getPdtNo()).files(dto.getImages()).build());
        return ResponseEntity.ok().body(1);
    }

    // 상품 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid PdtDto.Update dto, Principal principal) throws IOException {
        pdtApp.update(dto, principal.getName());
        if (dto.getImages() != null) {
            pdtImgApp.update(PdtImgDto.ListFile.builder().pdtNo(dto.getPdtNo()).files(dto.getImages()).build());
        }
        return ResponseEntity.ok().body(1);
    }

    // 상품 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@NotNull Long pdtNo, Principal principal) throws IOException {
        pdtApp.delete(pdtNo, principal.getName());
        pdtImgApp.deleteAll(pdtNo);
        pdtFavoriteApp.delete(PdtFavoriteDto.Delete.builder().pdtNo(pdtNo).build(), principal.getName());
        pdtRptApp.deleteByRptPdtNo(pdtNo);
        return ResponseEntity.ok().body(1);
    }

    // 상품 조회
    @GetMapping("find-by-pdt-no")
    public ResponseEntity<PdtDto.Detail> findByPdtNo(@NotNull Long pdtNo, Principal principal) {
        return ResponseEntity.ok().body(pdtApp.findByPdtNo(pdtNo, principal.getName()));
    }

    // 상품 목록 조회
    @GetMapping("find-all-by-data")
    public ResponseEntity<List<PdtDto.ReadList>> findAllByData(@Valid PdtDto.ListData dto, Principal principal, BindingResult bindingResult) {
        return ResponseEntity.ok().body(pdtApp.findAllByData(dto, principal.getName()));
    }

    // 판매자 찾기
    @GetMapping("find-pdt-seller-no")
    public ResponseEntity<Long> findPdtSellerNo(@NotNull Long pdtSellerNo, Principal principal) {
        return ResponseEntity.ok().body(pdtApp.findPdtSellerNo(pdtSellerNo));
    }

    // 등록한 상품 조회
    @GetMapping("find-all-by-mem-no")
    public ResponseEntity<List<PdtDto.ReadList>> findAllByMemNo(Principal principal) {
        return ResponseEntity.ok().body(pdtApp.findAllByMemNo(principal.getName()));
    }
}
