package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrdImgRepo {
    //이미지 작성
    public Integer save();

    //이미지수정
    public Integer update();
    //이미지삭제
    public Integer delete();
    //이미지적용 게시물
    public Long findAllByBrdNo();
}
