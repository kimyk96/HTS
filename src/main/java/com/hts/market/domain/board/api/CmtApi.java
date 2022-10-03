package com.hts.market.domain.board.api;


import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.CmtDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class CmtApi {

    // 댓글 작성
    @PostMapping("cmt-save")
    public ResponseEntity<Integer> save(CmtDto.Create dto){
        return null;
    }


    // 댓글수정
    @PutMapping("cmt-update")
    public ResponseEntity<Integer> update(CmtDto.Update dto){
        return null;
    }


    // 댓글삭제
    @DeleteMapping("cmt-delete")
    public ResponseEntity<Integer> delete(CmtDto.Delete dto){
        return null;
    }


    // 댓글작성자
    @GetMapping("cmt-find-mem")
    public ResponseEntity<Long> findMemNoByCmtNo(Long cmtNo){
        return null;
    }

    // 댓글작성시간
    @GetMapping("cmt-crated-at")
    public ResponseEntity<LocalDateTime> findCreatedAtByCmtNo(Long cmtNo){
        return null;
    }

    // 댓글을 남길 게시물
    @PostMapping("find-brd")
    public ResponseEntity<Long> findBrdNo(BrdDto dto){
        return null;
    }
}

