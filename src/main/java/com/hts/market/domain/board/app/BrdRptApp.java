package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdRptDto;
import com.hts.market.domain.board.repo.BrdRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdRptApp {
    @Autowired BrdRptRepo brdRptRepo;

    // 글 신고
    public Integer save(BrdRptDto.Create dto) {
        return brdRptRepo.save(dto);
    }

    // 글 신고 삭제
    public Integer delete(BrdRptDto.Delete dto) {
        return brdRptRepo.delete(dto);
    }

    // 신고 목록
    public List<BrdRptDto.Read> findAll(BrdRptDto.Read dto) {
        return brdRptRepo.findAll(dto);
    }
}
