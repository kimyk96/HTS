package com.hts.market.domain.board.app;

import com.hts.market.domain.board.repo.BrdCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrdCateApp {

    @Autowired
    BrdCateRepo brdCateRepo;

    //게시글 카테고리 명을 번호를 통해 찾아라
    public Integer findBrdCateNameById(Long brdCateNo){
        return null;
    };

    //카테고리 불러오기
    public Integer findAll(){
        return null;
    };
}
