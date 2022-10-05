package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface BrdLikeRepo {
    //게시글 좋아요
    public Integer save();

    //좋아요 취소
    public Integer delete();

    //좋아요를 적용하는 게시물 번호
    public Long findBrdNoByMemNo();

    //좋아요를 적용하는 회원의 번호
    public Long findMemNoByBrdNo();
}
