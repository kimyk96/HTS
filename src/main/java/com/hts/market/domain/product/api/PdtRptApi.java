package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtRptApp;
import com.hts.market.domain.product.dto.PdtRptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/pdt-rpt")
public class

PdtRptApi {
    @Autowired
    private PdtRptApp pdtRptApp;

    // 신고등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid PdtRptDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(pdtRptApp.save(dto, principal.getName()));
    }
}
//    // 신고목록
//    @GetMapping("find-all-by-dto")
//    public ResponseEntity<List<PdtRptDto.Search>> findAllByDto(@Valid  PdtRptDto.Search dto){
//        return ResponseEntity.ok().body(pdtRptApp.findAllByDto(dto));
//    }
//    // 신고번호삭제
//    @DeleteMapping("delete-by-rpt-no")
//    public ResponseEntity<Integer> deleteByRptNo(@NotNull Long pdtNo){
//        return ResponseEntity.ok().body(pdtRptApp.deleteOfRpt(pdtNo));
//    }
//    // 신고회원삭제
//    @DeleteMapping("delete-by-rpt-mem-no")
//    public ResponseEntity<Integer> deleteByRptMemNo(@Valid PdtRptDto.Delete dto){
//        return ResponseEntity.ok().body(pdtRptApp.deleteByRptMemNo(dto));
//    }
//    // 신고상품삭제
//    @DeleteMapping("delete-by-rpt-pdt-no")
//    public ResponseEntity<Integer> deleteByRptPdtNo(@NotNull Long pdtNo){
//        return ResponseEntity.ok().body(pdtRptApp.deleteByRptPdtNo(pdtNo));
//    }
//}
