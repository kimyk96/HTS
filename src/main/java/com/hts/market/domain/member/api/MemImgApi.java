package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemImgApp;
import com.hts.market.domain.member.dto.MemImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/mem-img")
public class MemImgApi {
    @Autowired MemImgApp memImgApp;

    // 이하 설계도에 있는 메소드들

    // 회원 이미지 추가
    @PostMapping("save")
    public ResponseEntity<Integer> save(Part memImg) {
        return ResponseEntity.ok().body(memImgApp.save(memImg));
    }

    // 회원 이미지 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long memNo) {
        return ResponseEntity.ok().body(memImgApp.delete(memNo));
    }

    // 회원 이미지 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(MemImgDto dto) {
        return ResponseEntity.ok().body(memImgApp.update(dto));
    }

    // 회원 이미지 조회
    @GetMapping("find-by-id")
    public ResponseEntity<String> findById(Long memNo) {
        return ResponseEntity.ok().body(memImgApp.findById(memNo));
    }
}
