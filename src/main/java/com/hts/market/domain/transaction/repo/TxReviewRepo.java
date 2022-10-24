package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TxReviewRepo {
    public Integer save(TxReviewDto.Create dto);

    public Integer delete(Long txNo, String txReviewType);

    Optional<List<TxReviewDto.Read>> findBuyerByTxReviewNo(TxReviewDto.Read dto);
    Optional<List<TxReviewDto.Read>> findSellerByTxReviewNo(TxReviewDto.Read dto);
    Boolean findByTxNoAndTxReviewType(Long txNo, String txReviewType);

    List<String> findAllByTxNo(TxReviewDto.Read dto);
}
