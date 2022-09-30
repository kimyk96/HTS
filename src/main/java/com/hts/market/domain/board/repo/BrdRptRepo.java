package com.hts.market.domain.board.repo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrdRptRepo {
    public Integer save();
}
