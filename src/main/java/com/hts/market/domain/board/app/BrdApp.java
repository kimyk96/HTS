package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.board.exception.BoardNotFoundException;
import com.hts.market.domain.board.repo.*;
import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrdApp {
    @Autowired
    private BrdRepo brdRepo;
    @Autowired
    private MemRepo memRepo;
    @Autowired
    private BrdLikeRepo brdLikeRepo;
    @Autowired
    private BrdImgRepo brdImgRepo;
    @Autowired
    private BrdRptRepo brdRptRepo;
    @Autowired
    private CmtRepo cmtRepo;

    @Value("${hts.imgUrl}") private String imgUrl;

    //게시물작성
    public Integer save(BrdDto.Create dto, String memUsername) {
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(memUsername));
        return brdRepo.save(dto); };

    //게시물 수정
    public Integer update(BrdDto.Update dto, String userName)
    {   dto.setBrdWriterNo(memRepo.findIdByMemUsername(userName));
        return brdRepo.update(dto);
    };

    //게시물 삭제
    public Integer delete(BrdDto.Delete dto, String userName){
        dto.setBrdWriterNo(memRepo.findIdByMemUsername(userName));
        return brdRepo.delete(dto);

    };

    //게시물 읽기
    public BrdDto.Detail findByBrdNo(Long brdNo, String memUserName) {   //게시물 정보
        BrdDto.Detail dto = brdRepo.findByBrdNo(brdNo).orElseThrow(() -> new BoardNotFoundException());
        for (BrdImgDto.Read read : dto.getImages()) {
            read.setImgPath(imgUrl + read.getImgPath());
        }
        // 회원정보
        MemDto.Member member = memRepo.findById(dto.getBoard().getBrdWriterNo()).orElseThrow(() -> new MemberNotFoundException());
        member.setImgPath(imgUrl + member.getImgPath());
        dto.setMember(member);
        // 좋아요수
        dto.getBoard().setBrdLikeCount(brdLikeRepo.countByBrdNo(brdNo));
        // 좋아여체크
        dto.getBoard().setCheckLikes(brdLikeRepo.active(BrdLikeDto.CheckLikes.builder().brdNo(brdNo).memNo(memRepo.findIdByMemUsername(memUserName)).build()));
        //조회수 체크
        brdRepo.findViewsByBrdNo(brdNo, memRepo.findIdByMemUsername(memUserName));
        //댓글 정보
        List<CmtDto.Read> cmtList = cmtRepo.findAll(brdNo);
        dto.setCmtList(cmtList);
        return dto;
    };

    //게시글 목록
    public List<BrdDto.ReadList> findAllByData(BrdDto.ListData dto, String userName){
        List<BrdDto.ReadList> list = brdRepo.findAllByData(dto);
        Long memNo = memRepo.findIdByMemUsername(userName);
        for(BrdDto.ReadList brd : list){
            // 이미지 출력
            brd.setImgPath(imgUrl + brd.getImgPath());
            // 조회수
            brd.setBrdViews(brdRepo.findViewsByBrdNo(dto.getBrdNo(), memNo));
            // 좋아요수
            brd.setBrdLikeCount(brdLikeRepo.countByBrdNo(dto.getBrdNo()));
            // 좋아요체크
            brd.setBrdLikeCheck(brdLikeRepo.active(BrdLikeDto.CheckLikes.builder().brdNo(dto.getBrdNo()).memNo(memNo).build()));
        }
        return list;
    }





}
