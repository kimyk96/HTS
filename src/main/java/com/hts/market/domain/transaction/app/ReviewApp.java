package com.hts.market.domain.transaction.app;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewApp {
    @Autowired ReviewRepo reviewRepo;

    // 리뷰 조회
    public List<ReviewDto.Read> findByReviewNo() {
        return reviewRepo.findByReviewNo();
    }
}
