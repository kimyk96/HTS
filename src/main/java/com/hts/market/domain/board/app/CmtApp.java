package com.hts.market.domain.board.app;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CmtApp {
    // 댓글작성
    public Integer save(){
        return null;
    };
    
    //댓글수정
    public Integer update(){
        return null;
    };;
    
    //댓글 삭제
    public Integer delete(){
        return null;
    };;

    //댓글 작성자 정보
    public Long findMemNoByCmtNo(){
        return null;
    };

    //댓글 작성시간
    public LocalDateTime findCreatedAtByCmtNo(){
        return null;
    };

    //댓글 남길 게시물
    public Integer findBrdNo(){
        return null;
    };
}
