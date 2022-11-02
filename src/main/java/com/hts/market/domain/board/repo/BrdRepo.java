package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BrdRepo {
    // 글 쓰기
    Integer save(BrdDto.Create dto);

    // 글 수정
    Integer update(BrdDto.Update dto);

    // 글 삭제
    Integer delete(BrdDto.Delete dto);

    // 글 읽기
    Optional<BrdDto.Read> findByBrdNo(Long brdNo);

    // 글 조회수 증가
    Integer findViewsByBrdNo(Long brdNo, Long memNo);

    // 글쓴이 번호 찾기
    Long findWriterNoById(Long brdNo);

    // 회원별 글 목록
    List<BrdDto.ReadList> findAllByData(BrdDto.ListData dto);

    // 작성한 게시글 찾기
    List<BrdDto.ReadList> findAllByMemNo(Long memNo);
}
