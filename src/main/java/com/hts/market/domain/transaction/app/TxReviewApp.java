package com.hts.market.domain.transaction.app;

import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import com.hts.market.domain.transaction.exception.TransactionNotFoundException;
import com.hts.market.domain.transaction.repo.ReviewRepo;
import com.hts.market.domain.transaction.repo.TxRepo;
import com.hts.market.domain.transaction.repo.TxReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxReviewApp {
    @Autowired
    TxReviewRepo txReviewRepo;
    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    TxRepo txRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    MemRepo memRepo;



    public Integer save(TxReviewDto.Create dto, String username,TxDto.Read dto2) {

        Long pdtNo = txRepo.findById(dto2.getTxBuyerNo()).getTxPdtNo();
        Long sellerNo = pdtRepo.findSellerNoById(pdtNo);
        Long memNo = memRepo.findIdByMemUsername(username);

        if (memNo.equals(sellerNo)) {
            // 판매자
            dto.setTxReviewType("판매자 리뷰");
        } else {
            // 구매자
            dto.setTxReviewType("구매자 리뷰");
        }
        return txReviewRepo.save(dto);


    };

    public Integer delete(Long TxReviewNo) {

        return txReviewRepo.delete(TxReviewNo);
    }
//판매자에 대한 구매자 리뷰 목록 조회
    public List<TxReviewDto.Read> findBuyerByTxReviewNo(TxReviewDto.Read dto) {
        List<TxReviewDto.Read> read=txReviewRepo.findBuyerByTxReviewNo(dto)
                .orElseThrow(()->new TransactionNotFoundException());
        return read;
    }
//구매자에 대한 판매자 리뷰 목록 조회
    public List<TxReviewDto.Read> findSellerByTxReviewNo(TxReviewDto.Read dto) {
        List<TxReviewDto.Read> read=txReviewRepo.findSellerByTxReviewNo(dto)
                .orElseThrow(()->new TransactionNotFoundException());
        return read;
    }
}
