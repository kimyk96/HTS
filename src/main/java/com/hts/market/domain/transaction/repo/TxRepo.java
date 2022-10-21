package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.TxDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TxRepo {
    public Integer save(TxDto.Create dto);

    public Integer delete(Long txNo);

    public TxDto.Read findById(Long txNo);

    public Optional<List<TxDto.Read>> findSaleListByMemNo(Long memNo);

    public Optional<List<TxDto.Read>> findPurchaseListByMemNo(Long memNo);


}
