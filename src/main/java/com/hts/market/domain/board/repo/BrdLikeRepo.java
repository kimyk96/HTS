package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdLikeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BrdLikeRepo {
    //게시글 좋아요
    public Integer save(BrdLikeDto.Create dto);

    //좋아요 취소
    public Integer delete(BrdLikeDto.Delete dto);

  // 좋아요를 누른 목록
    public List<BrdLikeDto.Page> findBrdNoByMemNo(BrdLikeDto.Page dto);

    //좋아요 횟수
    public Integer countByBrdNo(BrdLikeDto.CountLikes dto);
}
