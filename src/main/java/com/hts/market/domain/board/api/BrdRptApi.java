package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdRptApp;
import com.hts.market.domain.board.dto.BrdRptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd-rpt")
@Secured("ROLE_USER")
public class BrdRptApi {
    @Autowired BrdRptApp brdRptApp;

    // 글 신고 등록
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdRptDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(brdRptApp.save(dto));
    }

    // 글 신고 목록
    @GetMapping("find-all")
    public ResponseEntity<List<BrdRptDto.Read>> findAll(@Valid BrdRptDto.Read dto) {
        return ResponseEntity.ok().body(brdRptApp.findAll(dto));
    }

    // 글 신고 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdRptDto.Delete dto) {
        return ResponseEntity.ok().body(brdRptApp.delete(dto));
    }
}
