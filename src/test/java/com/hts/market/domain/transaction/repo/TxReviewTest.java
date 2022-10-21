package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import com.hts.market.domain.transaction.entity.TxReviewEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class TxReviewTest {
    @Autowired TxReviewRepo txReviewRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    TxRepo txRepo;
   //복합키, 거래타입은 어떻게?
   @BeforeEach
   void boforeEach(){
        TxReviewDto.Create dto1 = TxReviewDto.Create.builder()
               .txReviewNo(1l).txReviewType("구매자 리뷰").reviewNo(1L).build();

       TxReviewDto.Create dto2 = TxReviewDto.Create.builder().txReviewNo(2l)
               .txReviewType("판매자 리뷰").reviewNo(1L).build();

       PdtDto.Create dto3 = PdtDto.Create.builder()
               .pdtNo(1l)
               .pdtAddressNo(1l)
               .pdtCateNo(1l)
               .pdtDesc("서렴ㅇ")
               .pdtName("ㅇㄹㄴ")
               .pdtPrice(7200)
               .pdtSellerNo(1l)
               .build();

       TxDto.Create dto4=TxDto.Create.builder().txNo(1l).txPdtNo(1l).txBuyerNo(1l).build();

       txReviewRepo.save(dto1);
       txReviewRepo.save(dto2);
       pdtRepo.save(dto3);
       txRepo.save(dto4);


   }

    //복합키
    //@Test
    public void delete(){
       Long TxreviewNo=1L;
        Integer result = txReviewRepo.delete(TxreviewNo);
        Assertions.assertThat(result).isEqualTo(1);

    }
    @Test
   public void findBuyerByTxReviewNo(){
        TxReviewDto.Read dto=TxReviewDto.Read.builder().txReviewNo(1L).txReviewType("구매자 리뷰").reviewNo(1L).build();
        Optional<List<TxReviewDto.Read>> result = txReviewRepo.findBuyerByTxReviewNo(dto);
        Assertions.assertThat(result)/*.hasSize(1)*/;
    }
    @Test
    public void findSellerByTxReviewNo(){
        TxReviewDto.Read dto=TxReviewDto.Read.builder().txReviewNo(2l).txReviewType("판매자 리뷰").reviewNo(1l).build();
        Optional<List<TxReviewDto.Read>> result = txReviewRepo.findSellerByTxReviewNo(dto);
        Assertions.assertThat(result)/*.hasSize(1)*/;
    }
}
