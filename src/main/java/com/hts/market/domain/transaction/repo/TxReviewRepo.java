package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TxReviewRepo {
    // 거래 리뷰 저장
    public Integer save(TxReviewDto.Create dto);

    // 거래 리뷰 삭제
    public Integer delete(Long txNo, String txReviewType);

    // 구매자 거래리뷰 조회
    Optional<List<TxReviewDto.Read>> findBuyerByTxReviewNo(TxReviewDto.Read dto);

    // 판매자 거래리뷰 조회
    Optional<List<TxReviewDto.Read>> findSellerByTxReviewNo(TxReviewDto.Read dto);

    // 거래 리뷰 등록 여부
    Boolean findByTxNoAndTxReviewType(Long txNo, String txReviewType);

    // 거래 리뷰 전체 조회
    List<String> findAllByTxNo(TxReviewDto.Read dto);
}
