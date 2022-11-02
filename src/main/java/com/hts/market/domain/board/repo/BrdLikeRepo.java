package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdLikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrdLikeRepo {
    // 글 좋아요
    public Integer save(BrdLikeDto.Create dto);

    // 글 좋아요 삭제
    public Integer delete(BrdLikeDto.Delete dto);

    // 글 좋아요 회원별 목록
    public List<BrdLikeDto.ReadList> findLikeByMemNo(Long memNo);

    // 좋아요 카운트
    public Integer countByBrdNo(Long brdNo);

    // 좋아요 체크
    public Boolean active(BrdLikeDto.CheckLikes dto);
    // 회원별 전체 삭제
    Integer deleteAllByMemNo(Long memNo);
}
