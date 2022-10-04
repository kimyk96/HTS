package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.repo.BrdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BrdApp {
    @Autowired BrdRepo brdrepo;
    //게시물작성
    public Integer save(BrdDto.Create dto){
        return null;
    };

    //게시물 수정
    public Integer update(BrdDto.Update dto){
        return null;
    };

    //게시물 삭제
    public Integer delete(BrdDto.Delete dto){
        return null;
    };

    //게시물 검색
    public Integer findByBrdNo(Long brdNo){return null;};

    //게시글 번호로 조회수 가져오기
    public Integer findViewsByBrdNo(Long brdNo){return null;}

    //게시물 작성시간
    public LocalDateTime findCreatedAtByBrdNo(Long brdNo){return null;}

    //게시물 카테고리 등록
    public Integer findCateNoByBrdNo(Long brdNo){return null;}



}
