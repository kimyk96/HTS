package com.hts.market.domain.transaction.repo.transactionAppTest;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.app.TxReviewApp;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import com.hts.market.domain.transaction.repo.TxRepo;
import com.hts.market.domain.transaction.repo.TxReviewRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TxReviewAppTest {
    @Autowired
    TxReviewApp txReviewApp;
    @Autowired
    TxReviewRepo txReviewRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    TxRepo txRepo;
    @Autowired
    MemRepo memRepo;
    //복합키, 거래타입은 어떻게?
   /* @BeforeEach
    void boforeEach(){

        TxReviewDto.Create dto1 = TxReviewDto.Create.builder()
                .txReviewNo(1l).txReviewType("구매자 리뷰").reviewNo(1L).build();

        TxReviewDto.Create dto2 = TxReviewDto.Create.builder().txReviewNo(2l)
                .txReviewType("판매자 리뷰").reviewNo(1L).build();
        MemDto.Create dto4=MemDto.Create.builder().memNo(1L).memUsername("fdg").memNickname("fd").memEmail("dfgdfg").memPassword("1234").memIsEnabled(1).build();
        PdtDto.Create dto3 = PdtDto.Create.builder()
                .pdtNo(1l)
                .pdtAddressNo(1l)
                .pdtCateNo(1l)
                .pdtDesc("서렴ㅇ")
                .pdtName("ㅇㄹㄴ")
                .pdtPrice(7200)
                .pdtSellerNo(1l)
                .build();

        TxDto.Create dto5=TxDto.Create.builder().txNo(1l).txPdtNo(1l).txBuyerNo(1l).build();

        txReviewRepo.save(dto1);
        txReviewRepo.save(dto2);
        pdtRepo.save(dto3);
        txRepo.save(dto5);
        memRepo.save(dto4);


    }*/
  @Test
    void save(){
    TxReviewDto.Create dto = TxReviewDto.Create.builder().txReviewNo(2L).reviewNo(1L).txReviewType("구매자 리뷰").build();
    TxDto.Read dto2=TxDto.Read.builder().txNo(1L).txPdtNo(1L).txBuyerNo(1L).build();
    Integer result=txReviewApp.save(dto,"1",dto2);

    Assertions.assertThat(result).isEqualTo(1);

    }
}
/*@Test
void findBuyerByTxReviewNo(){
TxReviewDto.Read dto=TxReviewDto.Read.builder().txReviewNo(1L).reviewNo(1L).txReviewType("판매자 리뷰").build();
txReviewRepo.findBuyerByTxReviewNo(dto);
}
@Test
void findSellerByTxReviewNo(){
    TxReviewDto.Read dto=TxReviewDto.Read.builder().txReviewNo(2L).reviewNo(1L).txReviewType("판매자 리뷰").build();
    txReviewRepo.findBuyerByTxReviewNo(dto);
}*/
//}
