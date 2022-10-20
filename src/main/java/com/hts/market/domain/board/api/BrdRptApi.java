package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdRptApp;
import com.hts.market.domain.board.dto.BrdRptDto;
import com.hts.market.domain.product.app.PdtRptApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd-rpt")
public class BrdRptApi {
    @Autowired
    BrdRptApp brdRptApp;


    //신고 등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdRptDto.Create dto, Principal principal){
        return ResponseEntity.ok().body(brdRptApp.save(dto));
    }

    //신고목록
    @GetMapping("find-all")
    public ResponseEntity<List<BrdRptDto.Read>> findAll(@Valid BrdRptDto.Read dto){
        return ResponseEntity.ok().body(brdRptApp.findAll(dto));
    }

    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdRptDto.Delete dto){
        return ResponseEntity.ok().body(brdRptApp.delete(dto));
    }
}
