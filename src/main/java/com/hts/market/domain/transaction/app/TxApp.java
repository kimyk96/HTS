package com.hts.market.domain.transaction.app;

import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.repo.TxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxApp {
    @Autowired
    TxRepo txRepo;

    public Integer save() {
        return null;
    }

    public Integer delete() {
        return null;
    }

    public List<TxDto.Read> findAllByMemNo() {return null;}

    public TxDto.Read findById() {return  null;}
}
