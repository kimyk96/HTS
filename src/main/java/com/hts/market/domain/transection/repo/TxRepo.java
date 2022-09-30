package com.hts.market.domain.transection.repo;

import com.hts.market.domain.transection.dto.TxDto;
import com.hts.market.domain.transection.entity.TxEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TxRepo {
    public TxEntity save(TxDto.Create dto);

    public Integer delete(long txNo);

    public TxDto.Read findByTxNo(long txNo);

    public List<TxDto.Read> findAllByMemNo(long memNo);


}
