package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BrdRepo {
    //글쓰기
    Integer save(BrdDto.Create dto);
            //리턴 받는 타입
    //글 수정
    Integer update(BrdDto.Update dto);

    //글 삭제
    Integer delete(BrdDto.Delete dto );

    //게시물 읽기
    Optional<BrdDto.Detail> findByBrdNo(Long brdNo);

    //게시글 번호로 조회수 가져오기(조회수증가)
    Integer findViewsByBrdNo(Long brdNo, Long memNo);

    //게시물 찾기

    List<BrdDto.Read> searchByKeyword(BrdDto.SearchData dto);

    //카테고리 등록

    Long findCateNoByBrdNo(Long brdNo);
}
