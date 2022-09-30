package com.hts.market.domain.board.App;

import java.time.LocalDateTime;

public class BrdApp {
    //게시물작성
    public Integer save();

    //게시물 수정
    public Integer update();

    //게시물 삭제
    public Integer delete();

    //게시물 검색
    public Integer findByBrdNo();

    //게시글 번호로 조회수 가져오기
    public Integer findViewsByBrdNo();

    //게시물 작성시간
    public LocalDateTime findCreatedAtByBrdNo();

    //게시물 카테고리 등록
    public  Integer findCateNoByBrdNo();



}
