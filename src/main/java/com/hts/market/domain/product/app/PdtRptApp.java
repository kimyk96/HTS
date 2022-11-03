package com.hts.market.domain.product.app;


import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.exception.ReportCountExcessException;
import com.hts.market.domain.product.exception.ReportSaveFailException;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class PdtRptApp {
    @Autowired
    private PdtRptRepo pdtRptRepo;
    @Autowired
    private MemRepo memRepo;
    @Autowired
    private PdtApp pdtApp;

    // 신고등록
    public Integer save(PdtRptDto.Create dto, String userName) {
        // 로그인한 사용자(신고자 번호)
        Long memNo = memRepo.findIdByMemUsername(userName);
        // 사용자 번호값 넣기
        dto.setRptMemNo(memNo);
        // 이미 신고한 사용자
        Integer rptExist = pdtRptRepo.findIdBySearch(PdtRptDto.Search.builder()
                .rptPdtNo(dto.getRptPdtNo())
                .rptMemNo(dto.getRptMemNo())
                .build());
        // 신고자 일일 신고횟수 체크
        Integer rptCount = pdtRptRepo.countOfMemNo(memNo);
        // 신고자번호와 이미저장된 번호가 일치한다면 저장 실패 예외처리
        if (rptExist.equals(1)) {
            throw new ReportSaveFailException();
            // 회원 당 신고횟수가 5이상이면 저장 실패 예외처리
        } else if (rptCount >= 5) {
            throw new ReportCountExcessException();
        } else {
            return pdtRptRepo.save(dto);
        }
    }

    // 신고누적 5회시 글 삭제
    // 스케줄을 사용해서 1시간마다 실행
    @Scheduled(cron = "0 0 0/1 * * *")
    public Integer deleteByCount() {
        // 신고누적 5개이상이된 상품번호를 찾는다
        List<Long> list = pdtRptRepo.findPdtNoByCount();
        // 삭제할 상품들을 삭제 , 같이 삭제해야 할 부분도 같이해준다
        for (Long pdtNo : list) {
            pdtRptRepo.deleteOfPdt(pdtNo);
            pdtRptRepo.deleteOfImg(pdtNo);
            pdtRptRepo.deleteOfFavorite(pdtNo);
            pdtRptRepo.deleteOfRpt(pdtNo);
        }
        return 1;
    }

    // 일일 신고 횟수 초기화
    @Scheduled(cron = "0 1 0 * * *")
    public Integer deleteOfCount(){
        return pdtRptRepo.deleteAll();
    }
    // 상품별 신고 삭제
    public Integer deleteByPdtNo(Long pdtNo) {
        return pdtRptRepo.deleteOfRpt(pdtNo);
    }
}
