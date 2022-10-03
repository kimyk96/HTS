package com.hts.market.domain.board.api;


import com.hts.market.domain.board.dto.BrdLikeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
public class BrdLikeApi {


    // 게시물 좋아요
    @PostMapping("brd-like-save")
    public ResponseEntity<Integer> save(BrdLikeDto.Create dto){
        return null;
    }

    // 게시물 좋아요 삭제
    @DeleteMapping("brd-like-delete")
    public ResponseEntity<Integer> delete(BrdLikeDto.Delete dto){
        return null;
    }

    // 좋아요를 적용할 게시물의 번호
    @GetMapping("find-brd-like-by-brd-no")
    public ResponseEntity<Integer> findBrdNoByMemNo(Long memNo){
        return null;
    }

    // 좋아요를 적용하는 회원의 번호
    @GetMapping("find-brd-like-by-mem-no")
    public ResponseEntity<Integer> findMemNoByBrdNo(Long brdNo){
        return null;
    }
}
