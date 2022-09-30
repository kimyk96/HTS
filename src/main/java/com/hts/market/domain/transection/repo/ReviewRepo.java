package com.hts.market.domain.transection.repo;

import com.hts.market.domain.transection.dto.ReviewDto;
import com.hts.market.domain.transection.entity.TxEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewRepo {
    public Integer save(long reviewNo);

    public Integer delete(long reviewNo);

    public ReviewDto.Read findByReviewNo(ReviewDto.Read dto);
}
