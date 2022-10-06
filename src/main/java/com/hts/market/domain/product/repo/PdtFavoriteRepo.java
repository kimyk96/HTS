package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtFavoriteDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtFavoriteRepo {
    // 관심 등록
    public Integer save(PdtFavoriteDto.Create dto);
    // 관심 해제
    public Integer delete(PdtFavoriteDto.Delete dto);
    // 관심 목록
    public List<PdtFavoriteDto.Page> findAllByPdtNo(PdtFavoriteDto.Page dto);
    // 관심수 확인
    public Integer countByPdtNo(PdtFavoriteDto.CountFavorite dto);
}
