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
public class BrdApi {

    // 게시물 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(){
        return null;
    }

    // 게시물 수정
    @PostMapping("update")
    public ResponseEntity<Integer> update(){
        return null;
    }

    //게시물 삭제
    @PostMapping("delete")
    public ResponseEntity<Integer> delete(){
        return null;
    }

    //게시물검색
    @PostMapping("find-by-brd-no")
    public ResponseEntity<Long> findByBrdNo(){
        return null;
    }

    //게시물번호로 조회수 가져오기
    @PostMapping("views")
    public ResponseEntity<Long> findViewsByBrdNo(){
        return null;
    }

    //게시물 작성시간
    @PostMapping("created-at")
    public ResponseEntity<LocalDateTime> findCreatedAtByBrdNo(){
        return null;
    }

    //카테고리 등록
    @PostMapping("brd-cate")
    public ResponseEntity<Long> findCateNoByBrdNo(){
        return null;
    }
}
