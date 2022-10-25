package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.BrdLikeApp;
import com.hts.market.domain.board.dto.BrdLikeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/brd-like")
@Secured("ROLE_USER")
public class BrdLikeApi {
    @Autowired private BrdLikeApp brdLikeApp;

    // 글 좋아요
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdLikeDto.Create dto, Principal principal) {
        return ResponseEntity.ok().body(brdLikeApp.save(dto, principal.getName()));
    }

    // 글 좋아요 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdLikeDto.Delete dto, Principal principal) {
        return ResponseEntity.ok().body(brdLikeApp.delete(dto, principal.getName()));
    }
}
