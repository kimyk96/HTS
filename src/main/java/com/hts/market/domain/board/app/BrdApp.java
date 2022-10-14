package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.exception.BoardNotFoundException;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdApp {
    @Autowired
    private BrdRepo brdRepo;
    @Autowired
    private MemRepo memRepo;
    //게시물작성
    public Integer save(BrdDto.Create dto, String memUsername) {
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(memUsername));
        return brdRepo.save(dto); };

    //게시물 수정
    public Integer update(BrdDto.Update dto){
        return brdRepo.update(dto);
    };

    //게시물 삭제
    public Integer delete(BrdDto.Delete dto){return brdRepo.delete(dto);};

    //게시물 읽기
    public BrdDto.Detail findByBrdNo(Long brdNo, String memUserName)
    {BrdDto.Detail dto = brdRepo.findByBrdNo(brdNo).orElseThrow(()->new BoardNotFoundException());
    Long memNo = memRepo.findIdByMemUsername(memUserName);
        brdRepo.findViewsByBrdNo(brdNo, memNo);
        return dto;

    };

    //게시물 찾기
    public List<BrdDto.Read> searchByKeyword(BrdDto.SearchData dto) {
        return brdRepo.searchByKeyword(dto);
    }




}
