package com.hts.market.domain.member.app;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.repo.BrdImgRepo;
import com.hts.market.domain.board.repo.BrdLikeRepo;
import com.hts.market.domain.board.repo.BrdRepo;
import com.hts.market.domain.board.repo.CmtRepo;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.exception.MemberImageSaveFailException;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.exception.NicknameAlreadyTakenException;
import com.hts.market.domain.member.repo.MemImgRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRoleRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MemApp {
    @Autowired MemRepo memRepo;
    @Autowired MemRoleRepo memRoleRepo;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired MemImgRepo memImgRepo;
    @Autowired PdtRepo pdtRepo;
    @Autowired PdtImgRepo pdtImgRepo;
    @Autowired PdtFavoriteRepo pdtFavoriteRepo;
    @Autowired BrdRepo brdRepo;
    @Autowired BrdImgRepo brdImgRepo;
    @Autowired BrdLikeRepo brdLikeRepo;
    @Autowired CmtRepo cmtRepo;


    @Value("${hts.imgUrl}") private String imgUrl;

    // 인증 코드
    public Integer code(String memUsername, String code, Long memNo) {
        // 회원번호 확인
        if (memNo == null) {
            // 이미 가입된 회원 확인
            Boolean usernameTaken = memRepo.countByMemUsername(memUsername);
            if (Boolean.TRUE.equals(usernameTaken)) {
                // 비밀번호 갱신
                MemDto.Update updateDto = MemDto.Update.builder().memUsername(memUsername).memPassword(passwordEncoder.encode(code)).build();
                return memRepo.updateMemPassword(updateDto);
            }
            // 가입되지 않은 회원 -> 가입
            MemDto.Create memCreateDto = MemDto.Create.builder().memUsername(memUsername).memPassword(passwordEncoder.encode(code)).memNickname("").memEmail("").memIsEnabled(1).build();
            memRepo.save(memCreateDto);
            MemRoleDto.Create memRoleDtoCreate = MemRoleDto.Create.builder().memNo(memCreateDto.getMemNo()).roleNo(2L).build();
            memRoleRepo.save(memRoleDtoCreate);
            MemImgDto.Create memImgDtoCreate = MemImgDto.Create.builder().memNo(memCreateDto.getMemNo()).imgPath("member/default.png").build();
            memImgRepo.save(memImgDtoCreate);
        } else {
            // memNo 있음
            return Integer.parseInt(code);
        }
        return 1;
    }

    // 인증된 유저 회원번호로 갱신
    public Integer updateMemUsernameById(String memUsername, Long memNo) {
        return memRepo.updateMemUsernameById(memUsername, memNo);
    }

    // 회원 정보 수정
    public Integer updateByMemUsername(MemDto.Update dto) {
        return memRepo.updateByMemUsername(dto);
    }

    // 회원번호로 정보 조회
    public MemDto.Member findById(Long memNo) {
        MemDto.Member member = memRepo.findById(memNo).orElseThrow(MemberNotFoundException::new);
        if (member.getImgPath() == null) {
            member.setImgPath("/img/example/profile.png");
        } else {
            member.setImgPath(imgUrl + member.getImgPath());
        }
        return member;
    }

    // 회원명으로 정보 조회
    public MemDto.Member findByName(String memUsername) {
        MemDto.Member member = memRepo.findByName(memUsername).orElseThrow(MemberNotFoundException::new);
        if (member.getImgPath() == null) {
            member.setImgPath("/img/example/profile.png");
        } else {
            member.setImgPath(imgUrl + member.getImgPath());
        }
        return member;
    }

    // 프로필 사진 & 닉네임 수정
    public Integer updateProfile(MemDto.Profile dto, String memUsername) {
        if (Boolean.TRUE.equals(memRepo.countByMemNickname(memUsername, dto.getMemNickname()))) {
            throw new NicknameAlreadyTakenException();
        }

        // 정보 저장 dto 생성
        dto.setMemUsername(memUsername);
        dto.setMemNo(memRepo.findIdByMemUsername(memUsername));
        if (dto.getImage() == null) {
            MemDto.Member member = MemDto.Member.builder().memNo(dto.getMemNo()).memNickname(dto.getMemNickname()).build();
            return memRepo.updateMemNickname(member);
        } else {
            try {
                String fileName = "member/" + dto.getMemUsername() + "." + dto.getImage().getOriginalFilename().substring(dto.getImage().getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                String imgSaveDir = new File("").getAbsolutePath() + "\\" + "/images/";
                File profileImg = new File(imgSaveDir + fileName);
                profileImg.getParentFile().mkdirs();
                dto.getImage().transferTo(profileImg);

                MemDto.Member member = MemDto.Member.builder().memNo(dto.getMemNo()).imgPath(fileName).memNickname(dto.getMemNickname()).build();
                memRepo.updateMemNickname(member);
                memImgRepo.update(member);
                return 1;
            } catch (IOException e) {
                throw new MemberImageSaveFailException();
            }
        }
    }

    // 회원명으로 회원번호 조회
    public Long findIdByMemUsername(String memUsername) {
        return memRepo.findIdByMemUsername(memUsername);
    }




    // 회원 탈퇴
    public Integer delete(String username) {
        MemDto.Member member = memRepo.findByName(username).orElseThrow(MemberNotFoundException::new);
        Long memNo = member.getMemNo();

        // 상품 삭제 ( 상품, 이미지, 좋아요 )
        pdtRepo.findAllByMemNo(memNo).stream().forEach(item->{
            // 상품 이미지 파일 삭제
            pdtImgRepo.searchOfPdtNo(item.getPdtNo()).stream().forEach(a->{
                File file = new File(new File("").getAbsolutePath() + "\\" + "/images/" + a.getImgPath());
                file.delete();
            });
            // 상품 이미지 삭제
            pdtImgRepo.deleteAll(item.getPdtNo());
            // 상품 좋아요 삭제
            pdtFavoriteRepo.delete(PdtFavoriteDto.Delete.builder().pdtNo(item.getPdtNo()).memNo(memNo).build());
            // 상품 삭제
            pdtRepo.delete(PdtDto.Delete.builder().pdtNo(item.getPdtNo()).pdtSellerNo(memNo).build());
        });
        // 좋아요 누른 상품목록 삭제
        pdtFavoriteRepo.deleteAllByMemNo(memNo);

        // 게시글 삭제 ( 게시글, 이미지, 좋아요, 댓글 )
        brdRepo.findAllByMemNo(memNo).stream().forEach(item->{
            // 댓글 전체 삭제
            cmtRepo.deleteAll(item.getBrdNo());
            // 게시글 이미지 파일 삭제
            brdImgRepo.searchOfBrdNo(item.getBrdNo()).stream().forEach(a->{
                File file = new File(new File("").getAbsolutePath() + "\\" + "/images/" + a.getImgPath());
                file.delete();
            });
            // 게시글 이미지 삭제
            brdImgRepo.deleteAll(item.getBrdNo());
            // 게시글 좋아요 삭제
            brdLikeRepo.delete(BrdLikeDto.Delete.builder().brdNo(item.getBrdNo()).memNo(memNo).build());
            // 게시글 삭제
            brdRepo.delete(BrdDto.Delete.builder().brdNo(item.getBrdNo()).brdWriterNo(memNo).build());
        });
        // 작성한 댓글 삭제
        cmtRepo.deleteAllByMemNo(memNo);
        brdLikeRepo.deleteAllByMemNo(memNo);

        // 회원 삭제 ( 회원, 주소, 권한, 이미지 )
        File file = new File(new File("").getAbsolutePath() + "\\" + "/images/" + member.getImgPath());
        file.delete();
        memImgRepo.delete(memNo);
        memRoleRepo.deleteAll(memNo);
        memRepo.delete(memNo);
        return 1;
    }
}
