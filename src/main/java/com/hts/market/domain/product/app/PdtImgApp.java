package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.repo.PdtImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtImgApp {
    @Autowired
    private PdtImgRepo pdtImgRepo;

    // 이미지 저장
    public Integer save(PdtImgDto.Create dto){
        return pdtImgRepo.save(dto);
    }

    // 이미지 수정
    public Integer update(PdtImgDto.Update dto){
        return pdtImgRepo.update(dto);
    }

    // 이미지 삭제
    public Integer delete(PdtImgDto.Delete dto){
        return pdtImgRepo.delete(dto);
    }

//    // 이미지 보기
//    public String findByImgNo(PdtImgDto.Read dto){
//        return pdtImgRepo.findMainImg(dto);
//    }
}
