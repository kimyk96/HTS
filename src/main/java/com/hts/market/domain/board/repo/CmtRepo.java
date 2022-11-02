package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.CmtDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CmtRepo {
    // 댓글 작성
    public Integer save(CmtDto.Create dto);

    // 댓글 수정
    public Integer update(CmtDto.Update dto);

    // 댓글 삭제
    public Integer delete(CmtDto.Delete dto);

    // 댓글 목록
    public List<CmtDto.Read> findAll(Long brdNo);

    // 댓글 전체 삭제
    Integer deleteAll(Long brdNo);

    // 댓글 작성 여부 확인
    Boolean countByBrdNoAndMemNo(Long brdNo, Long memNo);

    // 댓글 수 확인
    Integer countByBrdNo(Long brdNo);
    // 회원별 전체 삭제
    Integer deleteAllByMemNo(Long memNo);
}
