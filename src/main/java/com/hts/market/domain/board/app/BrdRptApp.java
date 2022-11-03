package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdRptDto;
import com.hts.market.domain.board.repo.BrdImgRepo;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.board.repo.BrdRptRepo;
import com.hts.market.domain.board.repo.CmtRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.exception.ReportCountExcessException;
import com.hts.market.domain.product.exception.ReportSaveFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@EnableScheduling
public class BrdRptApp {
    @Autowired BrdRptRepo brdRptRepo;
    @Autowired MemRepo memRepo;
    @Autowired BrdRepo brdRepo;
    @Autowired CmtRepo cmtRepo;
    @Autowired BrdImgRepo brdImgRepo;

    // 글 신고
    public Integer save(BrdRptDto.Create dto, String username) {
        // 로그인한 사용자(신고자 번호)
        Long memNo = memRepo.findIdByMemUsername(username);
        // 사용자 번호값 넣기
        dto.setRptMemNo(memNo);
        // 이미 신고한 사용자
        Integer rptExist = brdRptRepo.findIdBySearch(BrdRptDto.Search
                .builder()
                .rptBrdNo(dto.getRptBrdNo())
                .rptMemNo(dto.getRptMemNo())
                .build());
        // 신고자 일일 신고횟수 체크
        Integer rptCount = brdRptRepo.countOfMemNo(memNo);
        // 신고자번호와 이미저장된 번호가 일치한다면 저장 실패 예외처리
        if (rptExist.equals(1)) {
            throw new ReportSaveFailException();
            // 회원 당 신고횟수가 5이상이면 저장 실패 예외처리
        } else if (rptCount >= 5) {
            throw new ReportCountExcessException();
        } else {
            return brdRptRepo.save(dto);
        }
    }

    // 신고누적 5회시 글 삭제
    // 스케줄을 사용해서 1시간마다 실행
    @Scheduled(cron = "0 0 0/1 * * *")
    public void deleteByCount() {
        brdRptRepo.findBrdNoByCount().stream().forEach(target->{
            brdImgRepo.searchOfBrdNo(target).stream().forEach(a->{
                File file = new File(new File("").getAbsolutePath() + "\\" + "/images/" + a.getImgPath());
                file.delete();
            });
            brdImgRepo.deleteAll(target);
            cmtRepo.deleteAll(target);
            brdRepo.delete(BrdDto.Delete.builder().brdWriterNo(brdRepo.findWriterNoById(target)).brdNo(target).build());
        });
    }

    // 일일 신고 횟수 초기화
    @Scheduled(cron = "0 1 0 * * *")
    public Integer deleteOfCount(){
        return brdRptRepo.deleteAll();
    }

}
