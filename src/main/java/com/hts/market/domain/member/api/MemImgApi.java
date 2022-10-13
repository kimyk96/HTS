package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemImgApp;
import com.hts.market.domain.member.dto.MemImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/mem-img")
public class MemImgApi {
    @Autowired MemImgApp memImgApp;

    // 회원 이미지 추가
    @PostMapping("save")
    public ResponseEntity<Integer> save(Part memImg) {
        MemImgDto.Create dto = MemImgDto.Create.builder().build();
        return ResponseEntity.ok().body(memImgApp.save(dto));
    }

    // 회원 이미지 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(MemImgDto.Delete dto) {
        return ResponseEntity.ok().body(memImgApp.delete(dto));
    }
}
