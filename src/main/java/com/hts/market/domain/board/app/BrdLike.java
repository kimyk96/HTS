package com.hts.market.domain.board.app;

public class BrdLike {
    //게시글 좋아요
    public Integer save();

    //게시글 좋아요 취소
    public Integer delete();

    //좋아요를 적용할 게시물의 번호
    public Integer findBrdNoByMemNo();

    //좋아요를 적용하는 회원의 번호
    public Integer findMemNoByBrdNo();
}
