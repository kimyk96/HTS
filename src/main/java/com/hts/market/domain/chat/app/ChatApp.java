package com.hts.market.domain.chat.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.repo.ChatRepo;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import com.hts.market.domain.product.exception.SellerNotFoundException;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.global.dto.MessageDto;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChatApp {
    @Autowired ChatRepo chatRepo;
    @Autowired PdtRepo pdtRepo;
    @Autowired MemRepo memRepo;
    @Autowired PdtImgRepo pdtImgRepo;
    @Value("${hts.imgUrl}") private String imgUrl;


    // 채팅 저장
    public Integer save(ChatDto.Create creDto, String username) {
        Long sellerNo = pdtRepo.findSellerNoById(creDto.getChatPdtNo());
        Long memNo = memRepo.findIdByMemUsername(username);
        if (memNo.equals(sellerNo)) {
            creDto.setChatIsSeller(1); // 판매자
        } else {
            creDto.setChatIsSeller(0); // 구매자
        }
        return chatRepo.save(creDto);
    }

    // 채팅 리스트 조회
    public List<ChatDto.Pk> findAllByUser(String username) {
        Long memNo = memRepo.findIdByMemUsername(username);
        // 채팅 리스트 조회
        List<ChatDto.Pk> seller = chatRepo.findAllAsSeller(memNo);
        List<ChatDto.Pk> buyer = chatRepo.findAllAsBuyer(memNo);
        // 필요 데이터 추가
        List<ChatDto.Pk> allUser = new ArrayList<>();
        seller.stream().forEach((ChatDto.Pk item) -> {
            // 기본 값 초기화
            item.setMember(MemDto.Member.builder().memNickname("탈퇴한 사용자").imgPath(imgUrl + "member/default.png").build());
            if (Boolean.TRUE.equals(memRepo.countByMemNo(item.getChatMemNo()))) {
                item.setMember(memRepo.findById(item.getChatMemNo()).orElseThrow(MemberNotFoundException::new));
                item.getMember().setImgPath(imgUrl + item.getMember().getImgPath());
            }
            if (pdtRepo.findByPdtNo(item.getChatPdtNo()).isEmpty()) {
                item.setPdtImg(imgUrl + "product/noImg.png");
            } else {
                item.setPdtImg(imgUrl + pdtImgRepo.findMainImg(item.getChatPdtNo()));
            }
            allUser.add(item);
        });
        buyer.stream().forEach((ChatDto.Pk item) -> {
            // 기본 값 초기화
            item.setMember(MemDto.Member.builder().memNickname("탈퇴한 사용자").imgPath(imgUrl + "member/default.png").build());
            if (pdtRepo.findByPdtNo(item.getChatPdtNo()).isEmpty()) {
                item.setPdtImg(imgUrl + "product/noImg.png");
            } else {
                if (Boolean.TRUE.equals(memRepo.countByMemNo(item.getChatMemNo()))) {
                    item.setMember(memRepo.findById(pdtRepo.findSellerNoById(item.getChatPdtNo())).orElseThrow(SellerNotFoundException::new));
                    item.getMember().setImgPath(imgUrl + item.getMember().getImgPath());
                }
                item.setPdtImg(imgUrl + pdtImgRepo.findMainImg(item.getChatPdtNo()));
            }
            allUser.add(item);
        });
        return allUser;
    }

    // 상품별 채팅 수
    public Integer countChatByPdtNo(Long chatPdtNo) {
        return chatRepo.countChatByPdtNo(chatPdtNo);
    }

    // 상품별 관심
    public Boolean countChatByPdtNoAndMemNo(ChatDto.ChatLike chatLike) {
        return chatRepo.countChatByPdtNoAndMemNo(chatLike);
    }

    // 회원간 채팅내역
    public ChatDto.ChatUserInfo findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, String memUsername) {
        // 채팅 불러오기
        List<ChatDto.Read> list = chatRepo.findAllByChatMemNoAndChatPdtNo(listStartEnd);
        // 상품 불러오기
        PdtDto.Detail pdtDto = pdtRepo.findByPdtNo(listStartEnd.getChatPdtNo()).orElseThrow(ProductNotFoundException::new);
        // 판매자 정보 추가
        pdtDto.setMember(memRepo.findById(pdtDto.getProduct().getPdtSellerNo()).orElseThrow(SellerNotFoundException::new));
        // 로그인 회원 정보
        MemDto.Member memInfo = memRepo.findByName(memUsername).orElseThrow(MemberNotFoundException::new);
        // 이미지 경로 불러오기
        pdtDto.getImages().get(0).setImgPath(imgUrl + pdtDto.getImages().get(0).getImgPath());
        memInfo.setImgPath(imgUrl + memInfo.getImgPath());
        // Dto 패키징
        return ChatDto.ChatUserInfo.builder().member(memInfo).product(pdtDto).chat(list).build();
    }

    // 메세지 보내기
    public MessageDto send(Message message, String chatPdtNo, String chatMemNo) {
        Long from       = memRepo.findIdByMemUsername(message.getFrom());
        Long pdtNo      = Long.parseLong(chatPdtNo);
        Long memNo      = Long.parseLong(chatMemNo);
        Long to         = from.equals(memNo) ? pdtRepo.findSellerNoById(pdtNo) : memNo;

        MessageDto msg = MessageDto.builder()
                .target(memRepo.findMemUsernameById(to))
                .now(LocalDateTime.now())
                .msg(message.getMsg())
                .build();
        return msg;
    }
}
