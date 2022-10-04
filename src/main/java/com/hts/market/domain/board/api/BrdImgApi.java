package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.BrdImgApp;
import com.hts.market.domain.board.dto.BrdImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdImgApi {
    @Autowired
    BrdImgApp brdimgapp;

    // 이미지작성
    @PostMapping("brd-Image-save")
    public ResponseEntity<Integer> save(BrdImgDto.Create dto){
        return null;
    }


    // 이미지수정
    @PutMapping("brd-Image-update")
    public ResponseEntity<Integer> update(BrdImgDto.Update dto){
        return null;
    }

    // 이미지삭제
    @DeleteMapping("brd-Image-delete")
    public ResponseEntity<Integer> delete(BrdImgDto.Delete dto){
        return null;
    }

    // 이미지를 적용할 게시물
    @GetMapping("find-brd-no")
    public ResponseEntity<Long> findAllByBrdNo(Long brdNo){
        return null;
    }
}
