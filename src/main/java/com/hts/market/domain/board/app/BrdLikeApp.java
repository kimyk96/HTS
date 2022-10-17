package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.repo.BrdLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdLikeApp {
    @Autowired
    private BrdLikeRepo brdLikeRepo;
    private Integer pagesize= 1000;
    //게시글 좋아요
    public Integer save(BrdLikeDto.Create dto){
        return brdLikeRepo.save(dto);
    };

    //게시글 좋아요 취소
    public Integer delete(BrdLikeDto.Delete dto){
        return brdLikeRepo.delete(dto);
    };
//
//    //좋아요를 누른 목록
//    public List<BrdLikeDto.ReadList> (Long memNo)
//    {return brdLikeRepo.findBrdNoByMemNo(memNo);}

//    //좋아요 횟수 (글에)
//    public Integer countByBrdNo(Long brdNo){
//        return null;
//    };
}

