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



    // 리뷰 등록
    public Integer save(TxReviewDto.SaveReview dto, String username) {
        dto.setMemNo(memRepo.findIdByMemUsername(username));
        Long sellerNo = pdtRepo.findSellerNoById(dto.getTxPdtNo());
        
        // 판매자 구매자 식별
        if(sellerNo.equals(dto.getMemNo())){
            dto.setTxReviewType("seller");
        }else{
            dto.setTxReviewType("buyer");
        }
        
        // 기존 리뷰 전체 삭제
        delete(dto.getTxNo(), username);

        // 리뷰 등록
        dto.getChecked().stream().forEach((item)->{
            txReviewRepo.save(TxReviewDto.Create.builder().reviewNo(item).txReviewType(dto.getTxReviewType()).txNo(dto.getTxNo()).build());
        });
        return 1;
    }

    public Integer delete(Long txNo, String username) {
        TxDto.Read transaction = txRepo.findById(txNo);
        Long sellerNo = pdtRepo.findSellerNoById(transaction.getTxPdtNo());
        if(sellerNo.equals(memRepo.findIdByMemUsername(username))){
            return txReviewRepo.delete(txNo, "seller");
        }else{
            return txReviewRepo.delete(txNo, "buyer");
        }
    }
////판매자에 대한 구매자 리뷰 목록 조회
//    public List<TxReviewDto.Read> findBuyerByTxReviewNo(TxReviewDto.Read dto) {
//        List<TxReviewDto.Read> read=txReviewRepo.findBuyerByTxReviewNo(dto)
//                .orElseThrow(()->new TransactionNotFoundException());
//        return read;
//    }
////구매자에 대한 판매자 리뷰 목록 조회
//    public List<TxReviewDto.Read> findSellerByTxReviewNo(TxReviewDto.Read dto) {
//        List<TxReviewDto.Read> read=txReviewRepo.findSellerByTxReviewNo(dto)
//                .orElseThrow(()->new TransactionNotFoundException());
//        return read;
//    }

    // 리뷰 전체 조회
    public TxReviewDto.ReadList findAllByTxNo(TxReviewDto.Read dto, String name) {
        TxReviewDto.ReadList result = TxReviewDto.ReadList.builder().txNo(dto.getTxNo()).build();

        if(Boolean.TRUE.equals(dto.getIsSeller())){
            // 판매자의 리뷰 확인
            dto.setTxReviewType("seller");
            result.setReviews(txReviewRepo.findAllByTxNo(dto));
            result.setMemNickname(memRepo.findById(pdtRepo.findByPdtNo(dto.getTxPdtNo()).get().getProduct().getPdtSellerNo()).get().getMemNickname());
            result.setPdtName(pdtRepo.findByPdtNo(dto.getTxPdtNo()).get().getProduct().getPdtName());
        }else{
            // 구매자의 리뷰 확인
            dto.setTxReviewType("buyer");
            result.setReviews(txReviewRepo.findAllByTxNo(dto));
            result.setMemNickname(memRepo.findById(txRepo.findById(dto.getTxNo()).getTxBuyerNo()).get().getMemNickname());
            result.setPdtName(pdtRepo.findByPdtNo(dto.getTxPdtNo()).get().getProduct().getPdtName());
        }
        return result;
    }
}
