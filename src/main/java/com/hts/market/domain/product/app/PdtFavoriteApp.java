package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdtFavoriteApp {
    @Autowired
    private PdtFavoriteRepo pdtFavoriteRepo;
    private Integer pageSize = 10;

    // 관심 등록
    public Integer save(PdtFavoriteDto.Create dto){
        return pdtFavoriteRepo.save(dto);
    }
    // 관심 해제
    public Integer delete(PdtFavoriteDto.Delete dto){
        return pdtFavoriteRepo.delete(dto);
    }
    // 관심 목록
    public List<PdtFavoriteDto.ReadList> findAllOfFavoriteList(Long memNo){
        return pdtFavoriteRepo.findAllOfFavoriteList(memNo);
    }
}
