package com.hts.market.domain.transection.repo;

import com.hts.market.domain.transection.dto.TxDto;
import com.hts.market.domain.transection.entity.TxEntity;

@Mapper
public interface TxRepo {
    public TxEntity save(TxDto.Create dto);

    public integer delete(long txNo);

    public TxDto findByTxNo(long txNo);


}
