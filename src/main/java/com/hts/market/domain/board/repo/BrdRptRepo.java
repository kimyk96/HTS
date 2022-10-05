package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface BrdRptRepo {
    public Integer save();
}
