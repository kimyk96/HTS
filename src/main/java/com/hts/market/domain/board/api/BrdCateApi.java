package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdCateApp;
import com.hts.market.domain.board.dto.BrdCateDto;
import com.hts.market.domain.product.dto.PdtCateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd-cate")
public class BrdCateApi {
    @Autowired
    BrdCateApp brdCateApp;

    // 게시물 좋아요 삭제
    @GetMapping("find-all")
    public ResponseEntity<List<BrdCateDto.Read>> findAll(){
        return ResponseEntity.ok().body(brdCateApp.findAll());
    }
}
