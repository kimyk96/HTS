package com.hts.market.domain.board.app;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BrdApp {
    //게시물작성
    public Integer save(){
        return null;
    };

    //게시물 수정
    public Integer update(){
        return null;
    };

    //게시물 삭제
    public Integer delete(){
        return null;
    };

    //게시물 검색
    public Integer findByBrdNo(){return null;};

    //게시글 번호로 조회수 가져오기
    public Integer findViewsByBrdNo(){return null;}

    //게시물 작성시간
    public LocalDateTime findCreatedAtByBrdNo(){return null;}

    //게시물 카테고리 등록
    public Integer findCateNoByBrdNo(){return null;}



}
