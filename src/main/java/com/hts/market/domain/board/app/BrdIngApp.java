package com.hts.market.domain.board.app;

public class BrdIngApp {
    //이미지 작성
    public Integer save();

    //이미지 수정
    public Integer update();

    //이미지삭제
    public Integer delete();

    //이미지적용 게시물
    public Integer findAllByBrdNo();

}
