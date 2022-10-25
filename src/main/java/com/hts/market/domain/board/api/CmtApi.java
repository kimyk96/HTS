package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.CmtApp;
import com.hts.market.domain.board.dto.CmtDto;
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
@RequestMapping("/api/v1/cmt")
@Secured("ROLE_USER")
public class CmtApi {
    @Autowired CmtApp cmtApp;

    // 댓글 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid CmtDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(cmtApp.save(dto, principal.getName()));
    }

    // 댓글 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(CmtDto.Update dto, Principal principal) {
        return ResponseEntity.ok().body(cmtApp.update(dto, principal.getName()));
    }

    // 댓글 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(CmtDto.Delete dto, Principal principal) {
        return ResponseEntity.ok().body(cmtApp.delete(dto, principal.getName()));
    }

    // 댓글 목록
    @GetMapping("find-all")
    public ResponseEntity<List<CmtDto.Read>> findMemNoByCmtNo(Long brdNo, Principal principal) {
        return ResponseEntity.ok().body(cmtApp.findAll(brdNo, principal.getName()));
    }
}

