package com.hts.market.domain.product.app;


import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.exception.ReportCountExcessException;
import com.hts.market.domain.product.exception.ReportSaveFailException;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Long reporter = pdtRptRepo.findIdBySearch(PdtRptDto.Search
                .builder()
                .rptPdtNo(dto.getRptPdtNo())
                .rptMemNo(dto.getRptMemNo())
                .build());
        // 신고자 일일 신고횟수 체크
        Integer rptCount = pdtRptRepo.countOfMemNo(memNo);
        // 신고자번호와 이미저장된 번호가 일치한다면 저장 실패 예외처리
        if (reporter != null && memNo.equals(reporter)) {
            throw new ReportSaveFailException();
            // 회원 당 신고횟수가 5이상이면 저장 실패 예외처리
        } else if (rptCount >= 5) {
            throw new ReportCountExcessException();
        } else {
            return pdtRptRepo.save(dto);
        }
    }

    // 신고누적 5회시 글 삭제
    @Scheduled(cron = "0 0 0/1 * * *")
    public Integer deleteByCount() {
        List<Long> list = pdtRptRepo.findPdtNoByCount();
        for (Long pdtNo : list) {
            pdtRptRepo.deleteOfPdt(pdtNo);
            pdtRptRepo.deleteOfImg(pdtNo);
            pdtRptRepo.deleteOfFavorite(pdtNo);
            pdtRptRepo.deleteOfRpt(pdtNo);
        }
        return 1;
    }

    // 상품별 신고 삭제
    public Integer deleteByPdtNo(Long pdtNo) {
        return pdtRptRepo.deleteOfRpt(pdtNo);
    }


    //@Scheduled(cron = "* * * * * *")
    // 신고번호로 신고삭제
//    public Integer deleteOfRpt(Long pdtNo) {
//        return pdtRptRepo.deleteByRptNo(pdtNo);
//    }

    // 게시글별로 신고된횟수 카운트 해서 몇이상은 삭제 또는 안삭제로 스케쥴돌리기
    // 회원번호로 신고삭제
//    public Integer deleteByRptMemNo(PdtRptDto.Delete dto) {
//        return pdtRptRepo.deleteByRptMemNo(dto);
//    }
}
//    // 상품번호로 신고삭제
//    public Integer deleteByRptPdtNo(Long pdtNo){
//        return pdtRptRepo.deleteByRptPdtNo(pdtNo);
//    }
//}
