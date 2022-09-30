package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtCateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PdtCateRepo {
    // 카테고리 목록
    public Integer findAll(PdtCateDto.Read dto);
}
