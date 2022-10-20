package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.repo.BrdLikeRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdLikeApp {
    @Autowired
    private BrdLikeRepo brdLikeRepo;
    @Autowired
    private MemRepo memRepo;
    //게시글 좋아요
    public Integer save(BrdLikeDto.Create dto, String userName){
        dto.setMemNo(memRepo.findIdByMemUsername(userName));
        return brdLikeRepo.save(dto);
    };

    //게시글 좋아요 취소
    public Integer delete(BrdLikeDto.Delete dto,String userName){
        dto.setMemNo(memRepo.findIdByMemUsername(userName));
        return brdLikeRepo.delete(dto);
    };

    //좋아요를 누른 목록
    public List<BrdLikeDto.ReadList> findBrdNoByMemNo(String userName)
    {return brdLikeRepo.findLikeByMemNo(memRepo.findIdByMemUsername(userName));}

//    //좋아요 횟수 (글)
//    public Integer countByBrdNo(Long brdNo){
//        return null;
//    };
}

