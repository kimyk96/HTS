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
    // 상품등록
//    @PreAuthorize("")
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtDto.Create dto, Principal principal) throws IOException {
        Integer pdtSave = pdtApp.save(dto, principal.getName());
        Integer pdtImgSave = pdtImgApp.save(PdtImgDto.ListFile.builder().pdtNo(dto.getPdtNo()).files(dto.getImages()).build());
        return ResponseEntity.ok().body(1);
    }

    // 상품수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid PdtDto.Update dto, Principal principal, BindingResult bindingResult) throws IOException {
        Integer pdtUpdate = pdtApp.update(dto, principal.getName());
        if (dto.getImages()!=null) {
            Integer pdtImgUpdate = pdtImgApp.update(PdtImgDto.ListFile.builder().pdtNo(dto.getPdtNo()).files(dto.getImages()).build());
        }
        return ResponseEntity.ok().body(1);
    }

    // 상품삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@NotNull Long pdtNo, Principal principal) throws IOException {
        Integer pdtDelete = pdtApp.delete(pdtNo, principal.getName());
        Integer pdtImgDelete = pdtImgApp.deleteAll(pdtNo);
        Integer pdtFavoriteDelete = pdtFavoriteApp.delete(PdtFavoriteDto.Delete.builder().pdtNo(pdtNo).build(), principal.getName());
        Integer pdtRptDelete = pdtRptApp.deleteByRptPdtNo(pdtNo);
       return ResponseEntity.ok().body(1);
    }

    // 판맥글 보기
    @GetMapping("find-by-pdt-no")
    public ResponseEntity<PdtDto.Detail> findByPdtNo(@NotNull Long pdtNo, Principal principal){
        PdtDto.Detail result = pdtApp.findByPdtNo(pdtNo, principal.getName());
        return ResponseEntity.ok().body(result);
    }

    // 목록 조회
    @GetMapping("find-all-by-data")
    public ResponseEntity<List<PdtDto.ReadList>> findAllByData(@Valid  PdtDto.ListData dto, Principal principal, BindingResult bindingResult) {
        return ResponseEntity.ok().body(pdtApp.findAllByData(dto, principal.getName()));
    }

    // 판매자 찾기
    @GetMapping("find-pdt-seller-no")
    public ResponseEntity<Long> findPdtSellerNo(@NotNull Long pdtSellerNo, Principal principal){
        return ResponseEntity.ok().body(pdtApp.findPdtSellerNo(pdtSellerNo));
    }


}
