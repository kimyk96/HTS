package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.BrdImgApp;
import com.hts.market.domain.board.dto.BrdImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/brd-img")
public class BrdImgApi {
    @Autowired
    BrdImgApp brdImgApp;

    // 이미지작성
//    @PostMapping("save")
//    public ResponseEntity<Integer> save(@Valid BrdImgDto.FileList dto)throws IOException {
//        return ResponseEntity.ok().body(brdImgApp.save(dto));
//    }


    // 이미지수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid BrdImgDto.FileList dto)throws IOException{
        return ResponseEntity.ok().body(brdImgApp.update(dto));
    }

    // 이미지삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdImgDto.Delete dto)
    {
        return ResponseEntity.ok().body(brdImgApp.delete(dto));
    }

    // 이미지 전체삭제
    @DeleteMapping("delete-all")
    public ResponseEntity<Integer> deleteAll(@NotNull BrdImgDto.Delete dto) throws IOException {
        return ResponseEntity.ok().body(brdImgApp.deleteAll(dto.getBrdNo()));
    }
}
