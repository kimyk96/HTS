package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdImgDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BrdImgRepo {
    //이미지 작성
    public Integer save(BrdImgDto.Create dto);

    //이미지수정
    public Integer update(BrdImgDto.Update dto);
    //이미지삭제
    public Integer delete(BrdImgDto.Delete dto);

    //대표이미지 보기
    public String findMainImg(Long brdNo);

    //이미지 전체 보기
    public List<BrdImgDto.Read> findAllByBrdNo(Long brdNo);


}
