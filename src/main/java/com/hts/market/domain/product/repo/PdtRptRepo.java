package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtRptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtRptRepo {
    // 신고등록
    public Integer save(PdtRptDto.Create dto);
    // 신고자번호 조회
    public Long findIdBySearch(PdtRptDto.Search dto);
    // 신고자 일일 신고횟수 체크
    public  Integer countOfMemNo(Long memNo);
    // 상품 신고횟수 체크
    public Integer countOfRptPdtNo(Long rptPdtNo);
    // 신고누적5회인 상품번호 조회
    public List<Long> findPdtNoByCount();
    // 상품 삭제
    public Integer deleteOfPdt(Long PdtNo);
    // 상품 이미지 삭제
    public Integer deleteOfImg(Long PdtNo);
    // 상품 관심 삭제
    public Integer deleteOfFavorite(Long PdtNo);
    // 상품 신고 삭제
    public Integer deleteOfRpt(Long PdtNo);
    // 신고전체삭제
    public Integer deleteAll();

    public Integer deleteByRptNo(PdtRptDto.Delete dto);
    // 회원별 삭제
    public Integer deleteByRptMemNo(PdtRptDto.Delete dto);





}
