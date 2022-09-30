package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrdRepo {
    //글쓰기
    public Integer save(BrdDto.Create dto);

    //글 수정
    public Integer update(BrdDto.Update dto);

    //글 삭제
    public Integer delete(Long brdNo);

}
