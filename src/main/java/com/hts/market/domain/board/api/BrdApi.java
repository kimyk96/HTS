package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdApp;
import com.hts.market.domain.board.dto.BrdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdApi {
    @Autowired BrdApp brdapp;

    // 게시물 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(BrdDto.Create dto){
        return null;
    }

    // 게시물 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(BrdDto.Update dto){
        return null;
    }

    //게시물 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long brdNo){
        return null;
    }

    //게시물검색
    @GetMapping("find-by-brd-no")
    public ResponseEntity<Long> findByBrdNo(Long brdNo){
        return null;
    }

    //게시물번호로 조회수 가져오기
    @GetMapping("views")
    public ResponseEntity<Long> findViewsByBrdNo(Long brdNo){
        return null;
    }

    //게시물 작성시간
    @GetMapping("created-at")
    public ResponseEntity<LocalDateTime> findCreatedAtByBrdNo(Long brdNo){
        return null;
    }

    //카테고리 등록
    @GetMapping("brd-cate")
    public ResponseEntity<Long> findCateNoByBrdNo(Long brdNo){
        return null;
    }
}
