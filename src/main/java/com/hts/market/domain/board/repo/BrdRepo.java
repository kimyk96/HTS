package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.product.dto.PdtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BrdRepo {
    //글쓰기
    Integer save(BrdDto.Create dto);
            //리턴 받는 타입
    //글 수정
    Integer update(BrdDto.Update dto);

    //글 삭제
    Integer delete(BrdDto.Delete dto);

    //게시물 읽기
    Optional<BrdDto.Detail> findByBrdNo(Long brdNo);

    //조회수증가
    Integer findViewsByBrdNo(Long brdNo, Long memNo);


    //글쓴이 찾기
    Long findWriterNoById(Long brdNo);

    // 회원별 게시글목록
    public List<BrdDto.ReadList> findAllByData(BrdDto.ListData dto);


}
