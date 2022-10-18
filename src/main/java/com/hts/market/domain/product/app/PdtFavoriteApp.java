package com.hts.market.domain.product.app;

import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdtFavoriteApp {
    @Autowired
    private PdtFavoriteRepo pdtFavoriteRepo;
    @Autowired
    private MemRepo memRepo;

    // 관심 등록
    public Integer save(PdtFavoriteDto.Create dto, String userName){
        dto.setMemNo(memRepo.findIdByMemUsername(userName));
        return pdtFavoriteRepo.save(dto);
    }
    // 관심 해제
    public Integer delete(PdtFavoriteDto.Delete dto){
        return pdtFavoriteRepo.delete(dto);
    }
    // 관심 목록
    public List<PdtFavoriteDto.ReadList> findAllOfFavoriteList(String userName){
        return pdtFavoriteRepo.findAllOfFavoriteList(memRepo.findIdByMemUsername(userName));
    }
}
