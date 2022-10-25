package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtCateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtCateRepo {
    // 테스트용 저장
    public Integer save(PdtCateDto.Create dto);

    // 카테고리 목록
    public List<PdtCateDto.Read> findAll();
}
