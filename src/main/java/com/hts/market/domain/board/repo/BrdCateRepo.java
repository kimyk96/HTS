package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdCateDto;
import com.hts.market.domain.product.dto.PdtCateDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BrdCateRepo {
    public Integer save(BrdCateDto.Create dto);
    //
    public List<BrdCateDto.Read> findAll();



}
