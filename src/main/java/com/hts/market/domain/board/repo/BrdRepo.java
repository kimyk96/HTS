package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper
public interface BrdRepo {
    //글쓰기
    public Integer save(BrdDto.Create dto);

    //글 수정
    public Integer update(BrdDto.Update dto);

    //글 삭제
    public Integer delete(Long brdNo);

    //게시물 검색
    public Long findByBrdNo();

    //게시글 번호로 조회수 가져오기
    public Long findViewsByBrdNo();

    //게시물 작성시간

    public LocalDateTime findCreatedAtByBrdNo();

    //카테고리 등록

    public Long findCateNoByBrdNo();
}
