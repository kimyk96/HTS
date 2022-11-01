package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.board.exception.BoardNotFoundException;
import com.hts.market.domain.board.repo.*;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BrdApp {
    @Autowired private BrdRepo brdRepo;
    @Autowired private MemRepo memRepo;
    @Autowired private BrdLikeRepo brdLikeRepo;
    @Autowired private CmtRepo cmtRepo;
    @Value("${hts.imgUrl}") private String imgUrl;

    // 글 작성
    public Integer save(BrdDto.Create dto, String memUsername) {
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(memUsername));
        dto.setBrdCateNo(1L);
        return brdRepo.save(dto);
    }

    // 글 수정
    public Integer update(BrdDto.Update dto, String userName) {
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(userName));
        return brdRepo.update(dto);
    }

    // 글 삭제
    public Integer delete(BrdDto.Delete dto, String userName) {
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(userName));
        return brdRepo.delete(dto);
    }

    // 글 읽기
    public BrdDto.Detail findByBrdNo(Long brdNo, String memUserName) {
        Long memNo = memRepo.findIdByMemUsername(memUserName);
        //게시물 정보
        BrdDto.Detail dto = brdRepo.findByBrdNo(brdNo).orElseThrow(BoardNotFoundException::new);
        for (BrdImgDto.Read read : dto.getImages()) {
            if (read.getImgPath() != null) {
                read.setImgPath(imgUrl + read.getImgPath());
            } else {
                dto.setImages(Collections.emptyList());
            }
        }
        // 회원정보
        MemDto.Member member = memRepo.findById(dto.getBoard().getBrdWriterNo()).orElseThrow(MemberNotFoundException::new);
        member.setImgPath(imgUrl + member.getImgPath());
        dto.setMember(member);
        // 좋아요수
        dto.getBoard().setBrdLikeCount(brdLikeRepo.countByBrdNo(brdNo));
        // 좋아여체크
        dto.getBoard().setCheckLikes(brdLikeRepo.active(BrdLikeDto.CheckLikes.builder().brdNo(brdNo).memNo(memNo).build()));
        //조회수 체크
        brdRepo.findViewsByBrdNo(brdNo, memNo);
        //댓글 정보
        dto.setCmtList(cmtRepo.findAll(brdNo));
        dto.getCmtList().forEach(item->{
            item.setImgPath(imgUrl + item.getImgPath());
            if (item.getCmtWriterNo().equals(memNo) && item.getCmtWriterNo().equals(member.getMemNo())) {
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
        return dto;
    }

    // 글 목록
    public List<BrdDto.ReadList> findAllByData(BrdDto.ListData dto, String userName) {
        List<BrdDto.ReadList> list = brdRepo.findAllByData(dto);
        Long memNo = memRepo.findIdByMemUsername(userName);
        for (BrdDto.ReadList brd : list) {
            // 이미지 출력
            if (brd.getImgPath() != null) {
                brd.setImgPath(imgUrl + brd.getImgPath());
            }
            // 조회수
            brd.setBrdViews(brdRepo.findViewsByBrdNo(brd.getBrdNo(), memNo));
            // 좋아요수
            brd.setBrdLikeCount(brdLikeRepo.countByBrdNo(brd.getBrdNo()));
            // 좋아요체크
            brd.setBrdLikeCheck(brdLikeRepo.active(BrdLikeDto.CheckLikes.builder().brdNo(brd.getBrdNo()).memNo(memNo).build()));
            // 댓글 개수
            brd.setCmtCount(cmtRepo.countByBrdNo(brd.getBrdNo()));
            // 댓글 등록여부
            brd.setCmtCheck(cmtRepo.countByBrdNoAndMemNo(brd.getBrdNo(), memNo));
        }
        return list;
    }

    // 작성한 글 목록
    public List<BrdDto.ReadList> findAllByMemNo(String username) {
        Long memNo = memRepo.findIdByMemUsername(username);
        List<BrdDto.ReadList> list = brdRepo.findAllByMemNo(memNo);
        list.stream().forEach(item -> {
            if (item.getImgPath() != null) {
                item.setImgPath(imgUrl + item.getImgPath());
            }
            item.setBrdViews(brdRepo.findViewsByBrdNo(item.getBrdNo(), memNo));
            item.setBrdLikeCount(brdLikeRepo.countByBrdNo(item.getBrdNo()));
            item.setBrdLikeCheck(brdLikeRepo.active(BrdLikeDto.CheckLikes.builder().brdNo(item.getBrdNo()).memNo(memNo).build()));
            item.setCmtCount(cmtRepo.countByBrdNo(item.getBrdNo()));
            item.setCmtCheck(cmtRepo.countByBrdNoAndMemNo(item.getBrdNo(), memNo));
        });
        return list;
    }
}
