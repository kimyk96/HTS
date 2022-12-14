package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewRepo {

    // 리뷰 조회
    public List<ReviewDto.Read> findByReviewNo();
}
