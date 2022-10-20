package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.board.repo.CmtRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CmtApp {
    @Autowired
    private CmtRepo cmtRepo;
    @Autowired
    private MemRepo memRepo;
    @Autowired
    private BrdRepo brdRepo;

    // 댓글작성
    public Integer save(CmtDto.Create dto,String memUsername){
                dto.setCmtWriterNo(memRepo.findIdByMemUsername(memUsername));
               return cmtRepo.save(dto);
    }

    //댓글수정
    public Integer update(CmtDto.Update dto, String memUserName){
        dto.setCmtWriterNo(memRepo.findIdByMemUsername(memUserName));
        return cmtRepo.update(dto);
    }

    //댓글 삭제
    public Integer delete(CmtDto.Delete dto, String memUsername){
        dto.setCmtWriterNo(memRepo.findIdByMemUsername(memUsername));
        return cmtRepo.delete(dto);
    }

    //댓글 목록
    public List<CmtDto.Read> findAll(Long brdNo){
        return cmtRepo.findAll(brdNo);
    }

    //댓글 전체 삭제
    public Integer deleteAll(Long brdNo){
        return cmtRepo.deleteAll(brdNo);
    }
}
