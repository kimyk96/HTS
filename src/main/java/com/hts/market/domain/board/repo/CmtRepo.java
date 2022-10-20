package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdCateDto;
import com.hts.market.domain.board.dto.CmtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CmtRepo {
    //댓글작성
    public Integer save(CmtDto.Create dto);

    //댓글수정
    public Integer update(CmtDto.Update dto);

    //댓글삭제

    public Integer delete(CmtDto.Delete dto);

    //댓글 목록
    public List<CmtDto.Read> findAll(Long brdNo);
    //댓글 전체삭제
    Integer deleteAll(Long brdNo);



//    //댓글을 남길 게시물
//    public Long findBrdNo();


}
