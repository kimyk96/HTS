package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
public interface BrdCateRepo {

    //게시글 카테고리를 명을 번호를 통해 찾아라
    public Long findBrdCateNameByCateNo();



}
