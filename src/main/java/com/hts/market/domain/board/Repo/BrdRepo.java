package com.hts.market.domain.board.Repo;

import com.hts.market.domain.board.Dto.BrdDto;
import com.hts.market.domain.member.dto.MemDto;

public interface BrdRepo {
    //글쓰기
    public Integer save(BrdDto.Create dto);

    //글 수정
    public Integer update(BrdDto.Update);

    //글 삭제
    public Integer delete(Long brdNo)

}
