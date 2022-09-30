package com.hts.market.domain.board.api;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdImgApi {

    // 이미지작성
    @PostMapping("brd-Image-save")
    public ResponseEntity<Integer> save(){
        return null;
    }


    // 이미지수정
    @PostMapping("brd-Image-update")
    public ResponseEntity<Integer> update(){
        return null;
    }

    // 이미지삭제
    @PostMapping("brd-Image-delete")
    public ResponseEntity<Integer> delete(){
        return null;
    }

    // 이미지를 적용할 게시물
    @PostMapping("find-brd-no")
    public ResponseEntity<Long> findAllByBrdNo(){
        return null;
    }
}
