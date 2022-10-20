package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.CmtApp;
import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.CmtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/cmt")
@Secured("ROLE_USER")
public class CmtApi {
    @Autowired
    CmtApp cmtApp;

    // 댓글 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid CmtDto.Create dto, Principal principal){

        return ResponseEntity.ok().body(cmtApp.save(dto, principal.getName()));
    }


    // 댓글수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(CmtDto.Update dto, Principal principal){
        return ResponseEntity.ok().body(cmtApp.update(dto, principal.getName()));
    }


    // 댓글삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(CmtDto.Delete dto, Principal principal){

        return ResponseEntity.ok().body(cmtApp.delete(dto, principal.getName()));
    }


    // 댓글목록
    @GetMapping("find-all")
    public ResponseEntity<List<CmtDto.Read>> findMemNoByCmtNo(Long brdNo){
        return ResponseEntity.ok().body(cmtApp.findAll(brdNo));
    }
//
//    // 댓글작성시간
//    @GetMapping("cmt-crated-at")
//    public ResponseEntity<LocalDateTime> findCreatedAtByCmtNo(Long cmtNo){
//        return null;
//    }
//
//    // 댓글을 남길 게시물
//    @PostMapping("find-brd")
//    public ResponseEntity<Long> findBrdNo(BrdDto dto){
//        return null;
//    }
}

