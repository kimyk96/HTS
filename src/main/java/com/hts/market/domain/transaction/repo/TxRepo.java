package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.TxDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TxRepo {
    // 거래 저장
    public Integer save(TxDto.Create dto);

    // 거래 삭제
    public Integer delete(Long txNo);

    // 거래 조회
    public TxDto.Read findById(Long txNo);

    // 판매내역 조회
    public List<TxDto.ReadList> findSaleListByMemNo(TxDto.GetList dto);

    // 구매내역 조회
    public List<TxDto.ReadList> findPurchaseListByMemNo(TxDto.GetList dto);

    //
    public Optional<TxDto.Read> findByPdtNoAndBuyerNo(TxDto.Create dto);
}
