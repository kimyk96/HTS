package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.*;
import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
@Secured("ROLE_USER")
public class BrdApi {
    @Autowired private BrdApp brdApp;
    @Autowired private BrdImgApp brdImgApp;
    @Autowired private BrdLikeApp brdLikeApp;
    @Autowired private CmtApp cmtApp;

    // 글 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdDto.Create dto, Principal principal) throws IOException {
        brdApp.save(dto, principal.getName());
        brdImgApp.save(BrdImgDto.ListFile.builder().brdNo(dto.getBrdNo()).files(dto.getFiles()).build());
        return ResponseEntity.ok().body(1);
    }

    // 글 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid BrdDto.Update dto, Principal principal) throws IOException {
        brdApp.update(dto, principal.getName());
        brdImgApp.update(BrdImgDto.ListFile.builder().brdNo(dto.getBrdNo()).files(dto.getImages()).build());
        return ResponseEntity.ok().body(1);
    }

    // 글 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdDto.Delete dto, Principal principal) throws IOException {
        brdImgApp.deleteAll(dto.getBrdNo());
        brdApp.delete(dto, principal.getName());
        brdLikeApp.delete(BrdLikeDto.Delete.builder().brdNo(dto.getBrdNo()).build(), principal.getName());
        cmtApp.deleteAll(dto.getBrdNo());
        return ResponseEntity.ok().body(1);
    }

    // 글 읽기
    @GetMapping("find-by-brd-no")
    public ResponseEntity<BrdDto.Detail> findByBrdNo(@NotNull Long brdNo, Principal principal) {
        return ResponseEntity.ok().body(brdApp.findByBrdNo(brdNo, principal.getName()));
    }

    // 글 목록 조회
    @GetMapping("find-all-by-data")
    public ResponseEntity<List<BrdDto.ReadList>> findAllByData(@Valid BrdDto.ListData dto, Principal principal) {
        return ResponseEntity.ok().body(brdApp.findAllByData(dto, principal.getName()));
    }

    // 내가 작성한 글목록
    @GetMapping("find-all-by-mem-no")
    public ResponseEntity<List<BrdDto.ReadList>> findAllByMemNo(Principal principal) {
        return ResponseEntity.ok().body(brdApp.findAllByMemNo(principal.getName()));
    }
}
