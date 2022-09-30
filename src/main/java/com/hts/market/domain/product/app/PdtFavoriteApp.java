package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtFavoriteApp {
    @Autowired
    private PdtFavoriteRepo pdtFavoriteRepo;

    // 관심 등록
    public PdtFavoriteDto.Create save(PdtFavoriteDto.Create dto){
        return null;
    }
    // 관심 해제
    public Integer delete(PdtFavoriteDto.Delete dto){
        return null;
    }
    // 관심 목록
    public Integer findAllByPdtNo(PdtFavoriteDto.Page dto){
        return null;
    }
    // 관심수 확인
    public Integer countByPdtNo(PdtFavoriteDto.CountFavorite dto){
        return null;
    }

}
