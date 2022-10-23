package com.hts.market.domain.transaction.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.repo.ChatRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.app.PdtApp;
import com.hts.market.domain.product.app.PdtStatus;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.exception.TransactionNotFoundException;
import com.hts.market.domain.transaction.exception.TransactionSaveFailException;
import com.hts.market.domain.transaction.repo.TxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TxApp {
    @Autowired
    TxRepo txRepo;
    @Autowired
    MemRepo memRepo;
    @Autowired
    ChatRepo chatRepo;
    @Autowired
    PdtRepo pdtRepo;



    /*pdtApp.PdtStatus.valueof("판매완료")*/
    public Integer save(TxDto.Create dto,PdtDto.Read dto2,Long txNo,Long pdtNo) {
 //       Integer TxPdtNo= dto.setTxPdtNo(pdtRepo.findByPdtNo(dto2.getPdtNo()));

    /*    Long pdtStatus = Long.valueOf(dto2.getPdtStatus());;
        //pdtStatus.get().
        Long txpdtNo = pdtRepo.findByPdtNo(dto2.getPdtNo());
        Long sellerNo = pdtRepo.findSellerNoById(txpdtNo);
        List<ChatDto.Pk> buyerNo=chatRepo.findAllAsBuyer(get);
        if(pdtStatus == 2) {
            dto.setTxPdtNo(txpdtNo);
            dto.setTxBuyerNo(buyerNo);
        }else{

        }*/
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
