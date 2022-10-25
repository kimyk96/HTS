package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdImgDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrdImgRepo {
    // 이미지 작성
    public Integer save(BrdImgDto.Create dto);

    // 이미지 수정
    public Integer update(BrdImgDto.Update dto);

    // 이미지 삭제
    public Integer delete(BrdImgDto.Delete dto);

    // 이미지 전체 삭제
    public Integer deleteAll(Long brdNo);

    // 대표 이미지 보기
    public String findMainImg(Long brdNo);

    // 이미지 조회
    List<BrdImgDto.Read> searchOfBrdNo(Long brdNo);
}
