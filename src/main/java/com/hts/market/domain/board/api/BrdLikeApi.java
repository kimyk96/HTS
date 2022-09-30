package com.hts.market.domain.board.api;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdLikeApi {


    // 게시물 좋아요
    @PostMapping("brd-like-save")
    public ResponseEntity<Integer> save(){
        return null;
    }

    // 게시물 좋아요 삭제
    @PostMapping("brd-like-delete")
    public ResponseEntity<Integer> delete(){
        return null;
    }

    // 좋아요를 적용할 게시물의 번호
    @PostMapping("find-brd-like-by-brd-no")
    public ResponseEntity<Integer> findBrdNoByMemNo(){
        return null;
    }

    // 좋아요를 적용하는 회원의 번호
    @PostMapping("find-brd-like-by-mem-no")
    public ResponseEntity<Integer> findMemNoByBrdNo(){
        return null;
    }
}
