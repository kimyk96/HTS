package com.hts.market.domain.transaction.app;

import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.exception.TransactionNotFoundException;
import com.hts.market.domain.transaction.repo.TxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxApp {
    @Autowired
    TxRepo txRepo;
    @Autowired
    MemRepo memRepo;

    public Integer save(TxDto.Create dto){
        return txRepo.save(dto);
    }


    public List<TxDto.Read> findSaleListByMemNo(String username) {
        List<TxDto.Read> read =  txRepo.findSaleListByMemNo(memRepo.findIdByMemUsername(username))
                .orElseThrow(()->new TransactionNotFoundException());
        return read;
    }

    public List<TxDto.Read> findPurchaseListByMemNo(String username) {
        List<TxDto.Read> read =   txRepo.findPurchaseListByMemNo(memRepo.findIdByMemUsername(username))
                .orElseThrow(()->new TransactionNotFoundException());
        return read;
    }

    public TxDto.Read findById(Long txNo) {
        TxDto.Read dto=txRepo.findById(txNo);
        return  dto;
    }
}
