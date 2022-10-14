package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.repo.BrdImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdImgApp {

    @Autowired
    BrdImgRepo brdImgRepo;
    //이미지 작성
    public Integer save(BrdImgDto.Create dto){
        return null;
    };

    //이미지 수정
    public Integer update(BrdImgDto.Update dto){
        return null;
    };

    //이미지삭제
    public Integer delete(BrdImgDto.Delete dto){
        return null;
    };

    //대표이미지 적용
    public String findMainImg(Long brdNo){return null;};

    //이미지 전체 보기

    public List<BrdImgDto.Read> findAllByBrdNo(Long brdNo){return null;};


}
