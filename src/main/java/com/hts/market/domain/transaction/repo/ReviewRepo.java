package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.transaction.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface ReviewRepo {

    public List<ReviewDto.Read> findByReviewNo();
}
