package com.hts.market.domain.transaction.app;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ReviewApp {
    @Autowired
    ReviewRepo reviewRepo;
    public List<ReviewDto.Read> findByReviewNo(Long reviewNo) {
        return  reviewRepo.findByReviewNo(reviewNo);
    }
}
