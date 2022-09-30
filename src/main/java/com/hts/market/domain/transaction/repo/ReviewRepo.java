package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewRepo {
    public Integer save(Long reviewNo);

    public Integer delete(Long reviewNo);

    public ReviewDto.Read findByReviewNo(ReviewDto.Read dto);
}
