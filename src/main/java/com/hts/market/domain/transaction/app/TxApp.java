package com.hts.market.domain.transaction.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.repo.ChatRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.exception.TransactionNotFoundException;
import com.hts.market.domain.transaction.repo.TxRepo;
import com.hts.market.domain.transaction.repo.TxReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxApp {
    @Autowired TxRepo txRepo;
    @Autowired MemRepo memRepo;
    @Autowired ChatRepo chatRepo;
    @Autowired PdtRepo pdtRepo;
    @Autowired PdtFavoriteRepo pdtFavoriteRepo;
    @Autowired TxReviewRepo txReviewRepo;
    @Value("${hts.imgUrl}") private String imgUrl;

    // 거래 내역 저장
    public Integer save(TxDto.Create dto, String sellerUsername) {
        // 기존 거래가 있는지 확인
        TxDto.Read tx = txRepo.findByPdtNoAndBuyerNo(dto).orElse(null);
        Long sellerNo = memRepo.findIdByMemUsername(sellerUsername);

        // 상품 상태 변경
        pdtRepo.update(PdtDto.Update.builder().pdtNo(dto.getTxPdtNo()).pdtSellerNo(sellerNo).pdtStatus(dto.getPdtStatus()).build());
        if (tx != null) {
            txRepo.delete(tx.getTxNo());
        }
        if (dto.getPdtStatus().equals(2)) {
            return txRepo.save(dto);
        } else {
            return 1;
        }
    }

    // 판매 내역 조회
    public List<TxDto.ReadList> findSaleListByMemNo(TxDto.GetList dto, String username) {
        if(dto.getMemNo()==null){
            dto.setMemNo(memRepo.findIdByMemUsername(username));
        }
        List<TxDto.ReadList> read = txRepo.findSaleListByMemNo(dto);
        if (read.isEmpty()) {
            throw new TransactionNotFoundException();
        } else {
            read.forEach(item -> {
                item.setPdtImg(imgUrl + item.getPdtImg());
                item.getProduct().setFavoriteCheck(pdtFavoriteRepo.active(item.getProduct().getPdtNo(), dto.getMemNo()));
                item.getProduct().setFavoriteCount(pdtFavoriteRepo.countByPdtNo(item.getProduct().getPdtNo()));
                item.setChatCount(chatRepo.countChatByPdtNo(item.getProduct().getPdtNo()));
                item.setChatCheck(chatRepo.countChatByPdtNoAndMemNo(ChatDto.ChatLike.builder().chatMemNo(dto.getMemNo()).chatPdtNo(item.getProduct().getPdtNo()).build()));
                item.setReceivedReviewCheck(txReviewRepo.findByTxNoAndTxReviewType(item.getTransaction().getTxNo(), "buyer"));
                item.setSentReviewCheck(txReviewRepo.findByTxNoAndTxReviewType(item.getTransaction().getTxNo(), "seller"));
            });
        }
        return read;
    }

    // 구매 내역 조회
    public List<TxDto.ReadList> findPurchaseListByMemNo(TxDto.GetList dto, String username) {
        if(dto.getMemNo()==null){
            dto.setMemNo(memRepo.findIdByMemUsername(username));
        }
        List<TxDto.ReadList> read = txRepo.findPurchaseListByMemNo(dto);
        if (read.isEmpty()) {
            throw new TransactionNotFoundException();
        } else {
            read.forEach(item -> {
                item.setPdtImg(imgUrl + item.getPdtImg());
                item.getProduct().setFavoriteCheck(pdtFavoriteRepo.active(item.getProduct().getPdtNo(), dto.getMemNo()));
                item.getProduct().setFavoriteCount(pdtFavoriteRepo.countByPdtNo(item.getProduct().getPdtNo()));
                item.setChatCount(chatRepo.countChatByPdtNo(item.getProduct().getPdtNo()));
                item.setChatCheck(chatRepo.countChatByPdtNoAndMemNo(ChatDto.ChatLike.builder().chatMemNo(dto.getMemNo()).chatPdtNo(item.getProduct().getPdtNo()).build()));
                item.setReceivedReviewCheck(txReviewRepo.findByTxNoAndTxReviewType(item.getTransaction().getTxNo(), "seller"));
                item.setSentReviewCheck(txReviewRepo.findByTxNoAndTxReviewType(item.getTransaction().getTxNo(), "buyer"));
            });
        }
        return read;
    }

    // 거래 조회
    public TxDto.Read findById(Long txNo) {
        return txRepo.findById(txNo);
    }
}
