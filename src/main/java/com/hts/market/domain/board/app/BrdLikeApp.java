package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.repo.BrdLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class BrdLikeApp {
    @Autowired
    BrdLikeRepo brdlikerepo;
    //게시글 좋아요
    public Integer save(BrdLikeDto.Create dto){
        return null;
    };

    //게시글 좋아요 취소
    public Integer delete(BrdLikeDto.Delete dto){
        return null;
    };

    //좋아요를 적용할 게시물의 번호
    public Long findBrdNoByMemNo(Long memNo){
        return null;
    };

    //좋아요를 적용하는 회원의 번호
    public Long findMemNoByBrdNo(Long brdNo){
        return null;
    };
}
