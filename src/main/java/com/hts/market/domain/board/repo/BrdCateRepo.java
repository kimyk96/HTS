package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrdCateRepo {

    //게시글 카테고리를 명을 번호를 통해 찾아라
    public Long findBrdCateNameByCateNo();

    //카테고리 불러오기

    public Integer findAll();


}
