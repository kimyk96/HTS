package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.board.repo.CmtRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtApp {
    @Autowired private CmtRepo cmtRepo;
    @Autowired private MemRepo memRepo;
    @Autowired private BrdRepo brdRepo;
    @Value("${hts.imgUrl}") private String imgUrl;

    // 댓글 작성
    public Integer save(CmtDto.Create dto, String memUsername) {
        dto.setCmtWriterNo(memRepo.findIdByMemUsername(memUsername));
        return cmtRepo.save(dto);
    }

    // 댓글 수정
    public Integer update(CmtDto.Update dto, String memUserName) {
        dto.setCmtWriterNo(memRepo.findIdByMemUsername(memUserName));
        return cmtRepo.update(dto);
    }

    // 댓글 삭제
    public Integer delete(CmtDto.Delete dto, String memUsername) {
        dto.setMemNo(memRepo.findIdByMemUsername(memUsername));
        return cmtRepo.delete(dto);
    }

    // 댓글 목록
    public List<CmtDto.Read> findAll(Long brdNo, String memUsername) {
        Long memNo = memRepo.findIdByMemUsername(memUsername);
        List<CmtDto.Read> list = cmtRepo.findAll(brdNo);
        list.forEach(item -> {
            item.setImgPath(imgUrl + item.getImgPath());
            if (item.getCmtWriterNo().equals(memNo) && item.getCmtWriterNo().equals(brdRepo.findWriterNoById(brdNo))) {
                item.setIsWriter(true);
                item.setIsBrdWriter(true);
            } else if (item.getCmtWriterNo().equals(memNo)) {
                item.setIsWriter(true);
                item.setIsBrdWriter(false);
            } else {
                item.setIsWriter(false);
                item.setIsBrdWriter(false);
            }
        });
        return list;
    }

    // 댓글 전체 삭제
    public Integer deleteAll(Long brdNo) {
        return cmtRepo.deleteAll(brdNo);
    }
}
