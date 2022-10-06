package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
public class ReviewTest {
    @Autowired ReviewRepo reviewRepo;

   @Test
    public void save(){
       // given
        ReviewDto.Read dto = ReviewDto.Read.builder().review("매우 좋아요").build();
       // when
       Integer result= reviewRepo.save(dto);
       // then
       Assertions.assertThat(result).isEqualTo(1L);
    }

    //@Test
    public void delete() {
        Integer reviewNo = reviewRepo.delete(1l);
        Assertions.assertThat(reviewNo).isEqualTo(1l);

    }
    //@Test
    public void findByReviewNo() {
        // given
        Long reviewNo = 1L;
        // when
        ReviewDto.Read result = reviewRepo.findByReviewNo(reviewNo);
        // then
        Assertions.assertThat(result.getReviewNo()).isEqualTo(reviewNo);
    }
}

