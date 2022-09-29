package com.hts.market.domain.board.Dao;

import java.time.LocalDateTime;

public interface CmtApp {
    // 댓글작성
    public Integer save();
    
    //댓글수정
    public Integer update();
    
    //댓글 삭제
    public Integer delete();

    //댓글 작성자 정보
    public Integer findMemNoByCmtNo();

    //댓글 작성시간
    public LocalDateTime findCreatedAtByCmtNo();

    //댓글 남길 게시물
    public Integer findBrdNo();
}
