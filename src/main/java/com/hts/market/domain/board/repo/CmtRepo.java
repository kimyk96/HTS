package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface CmtRepo {
    //댓글작성
    public Integer save();

    //댓글수정
    public Integer update();

    //댓글삭제
    public Integer delete();

    //댓글작성자정보
    public Long findMemNoByCmtNo();

    //댓글 작성시간
    public LocalDateTime findCreatedAtByCmtNo();

    //댓글을 남길 게시물
    public Long findBrdNo();


}
