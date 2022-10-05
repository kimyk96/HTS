package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdRptDto;
import com.hts.market.domain.board.repo.BrdRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrdRptApp {
    @Autowired
    BrdRptRepo brdRptRepo;
    //신고하기
    public Integer save(BrdRptDto.Create dto){
        return null;
    };
}
