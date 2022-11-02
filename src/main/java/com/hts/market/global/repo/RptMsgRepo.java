package com.hts.market.global.repo;

import com.hts.market.global.dto.RptMsgDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RptMsgRepo {
    List<RptMsgDto> findAll();
}
