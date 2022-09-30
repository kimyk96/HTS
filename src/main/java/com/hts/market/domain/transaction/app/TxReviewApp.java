package com.hts.market.domain.transaction.app;

import com.hts.market.domain.transaction.dto.ReviewDto;
import com.hts.market.domain.transaction.dto.TxReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxReviewApp {
    public Integer save(TxReviewDto.Create dto) {
        return null;
    }

    public Integer delete(Long TxReviewNo) {

        return null;
    }

    public List<ReviewDto.Read> findAllByMemNo(Long TxReviewNo) {

        return null;
    }
}
