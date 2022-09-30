package com.hts.market.domain.board.api;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class CmtApi {

    // 댓글 작성
    @PostMapping("cmt-save")
    public ResponseEntity<Integer> save(){
        return null;
    }


    // 댓글수정
    @PostMapping("cmt-update")
    public ResponseEntity<Integer> update(){
        return null;
    }


    // 댓글삭제
    @PostMapping("cmt-delete")
    public ResponseEntity<Integer> delete(){
        return null;
    }


    // 댓글작성자
    @PostMapping("cmt-find-mem")
    public ResponseEntity<Long> findMemNoByCmtNo(){
        return null;
    }

    // 댓글작성시간
    @PostMapping("cmt-crated-at")
    public ResponseEntity<LocalDateTime> findCreatedAtByCmtNo(){
        return null;
    }

    // 댓글을 남길 게시물
    @PostMapping("find-brd")
    public ResponseEntity<Long> findBrdNo(){
        return null;
    }
}

