package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import com.hts.market.domain.transaction.entity.TxReviewEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TxReviewTest {
    @Autowired TxReviewRepo txReviewRepo;
   //복합키, 거래타입은 어떻게?
    //@Test
    public void save(){
        TxReviewDto.Create dto = TxReviewDto.Create.builder()
                .txReviewType("구매 완료").reviewNo(1L).build();

        Integer result = txReviewRepo.save(dto);
        Assertions.assertThat(result).isEqualTo(1);
    }
    //복합키
    //@Test
    public void delete(){
        Long txReviewNo = txReviewRepo.delete(1l);
        Assertions.assertThat(txReviewNo).isEqualTo(1L);

    }
    @Test
   public void findAllTxReviewNo(){
        Long txReviewNo = 1L;

        Long result = txReviewRepo.findAllByTxReviewNo(txReviewNo);

        Assertions.assertThat(result);
        Assertions.assertThat(result).isEqualTo(1L);
    }
}
