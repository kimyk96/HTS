package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdCateDto;
import com.hts.market.domain.board.repo.BrdCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdCateApp {

    @Autowired
    private BrdCateRepo brdCateRepo;


    //카테고리 목록
    public List<BrdCateDto.Read> findAll(){
        return brdCateRepo.findAll();
    };
}
