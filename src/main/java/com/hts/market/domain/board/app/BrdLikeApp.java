package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.repo.BrdLikeRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdLikeApp {
    @Autowired private BrdLikeRepo brdLikeRepo;
    @Autowired private MemRepo memRepo;

    // 글 좋아요
    public Integer save(BrdLikeDto.Create dto, String userName) {
        dto.setMemNo(memRepo.findIdByMemUsername(userName));
        return brdLikeRepo.save(dto);
    }

    // 글 좋아요 삭제
    public Integer delete(BrdLikeDto.Delete dto, String userName) {
        dto.setMemNo(memRepo.findIdByMemUsername(userName));
        return brdLikeRepo.delete(dto);
    }

    // 글 좋아요 목록
    public List<BrdLikeDto.ReadList> findBrdNoByMemNo(String userName) {
        return brdLikeRepo.findLikeByMemNo(memRepo.findIdByMemUsername(userName));
    }
}

