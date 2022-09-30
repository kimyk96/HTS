package com.hts.market.domain.transection.repo;

import com.hts.market.domain.transection.dto.ReviewDto;
import com.hts.market.domain.transection.dto.TxReviewDto;
import com.hts.market.domain.transection.entity.TxReviewEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TxReviewRepo {
    public TxReviewEntity save(TxReviewDto.Create dto);

    public long delete(long TxReviewNo);

    public List<ReviewDto.Read> findAllbyMemNo(long memNo);
}
