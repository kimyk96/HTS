package com.hts.market.domain.board.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdCateApi {

    // 게시물 좋아요 삭제
    @PostMapping("find-brd-cate-name-by-id")
    public ResponseEntity<Long> findBrdCateNameByCateNo(){
        return null;
    }
}
