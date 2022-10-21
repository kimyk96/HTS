package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
public class ReviewTest {
    @Autowired ReviewRepo reviewRepo;

    @BeforeEach
    public void boforeEach(){



    }

  /*  @Test
    public void findByReviewNo() {
        // given

        // when
        List<ReviewDto.Read> result = reviewRepo.findByReviewNo();
        // then
        Assertions.assertThat(result).isEqualTo(result);
    }*/
}

