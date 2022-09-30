package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.entity.TxEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TxRepo {
    public Integer save(TxDto.Create dto);

    public Integer delete(Long txNo);

    public TxDto.Read findById(Long txNo);

    public List<TxDto.Read> findAllByMemNo(Long memNo);


}
