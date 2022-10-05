package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdCateApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd-cate")
public class BrdCateApi {
    @Autowired
    BrdCateApp brdCateApp;

    // 게시물 좋아요 삭제
    @GetMapping("find-brd-cate-name-by-id")
    public ResponseEntity<Long> findBrdCateNameByCateNo(Long brdCateNo){
        return null;
    }
}
