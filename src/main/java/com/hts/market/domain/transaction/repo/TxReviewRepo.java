package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import com.hts.market.domain.transaction.entity.TxReviewEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TxReviewRepo {
    public TxReviewEntity save(TxReviewDto.Create dto);

    public Long delete(Long TxReviewNo);

    public List<ReviewDto.Read> findAllbyMemNo(Long memNo);
}
