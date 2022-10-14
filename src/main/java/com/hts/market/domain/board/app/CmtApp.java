package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.board.repo.CmtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CmtApp {
    @Autowired
    CmtRepo cmtRepo;
    // 댓글작성
    public Integer save(CmtDto.Create dto){
        return cmtRepo.save(dto);
    };
    
    //댓글수정
    public Integer update(CmtDto.Update dto){
        return cmtRepo.update(dto);
    };
    
    //댓글 삭제
    public Integer delete(CmtDto.Delete dto){
        return null;
    };;

    //댓글 목록
    public Integer findBrdNo(BrdDto dto){
        return null;
    };
}
