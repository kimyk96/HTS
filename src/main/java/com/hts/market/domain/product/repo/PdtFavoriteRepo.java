package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtDto;
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
    public List<PdtDto.ReadList> findAllOfFavoriteList(PdtFavoriteDto.ReadList dto);

    // 상품별 관심수 확인
    public Integer countByPdtNo(Long pdtNo);

    // 관심글 확인
    public Boolean active(Long pdtNo, Long memNo);
}
