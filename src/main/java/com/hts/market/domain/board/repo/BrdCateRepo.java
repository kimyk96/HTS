package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdCateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrdCateRepo {
    Integer save(BrdCateDto.Create dto);

    List<BrdCateDto.Read> findAll();
}
