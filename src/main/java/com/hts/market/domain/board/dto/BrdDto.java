package com.hts.market.domain.board.dto;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long brdNo;
        private Long brdWriterNo;
        @NotEmpty private String brdTitle;
        @NotEmpty private String brdContent;
        private Long brdCateNo;
        private List<MultipartFile> files;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long brdNo;
        private String brdTitle;
        private String brdContent;
        private Integer brdViews;
        private LocalDateTime brdCreatedAt;
        private Long brdWriterNo;
        private LocalDateTime cmtCreatedAt;
        //게시물 좋아요 수
        private Integer brdLikeCount;
        //게시물 좋아요 체크
        private Boolean checkLikes;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        @NotNull private Long brdNo;
        private Long brdWriterNo;
        private String brdTitle;
        private String brdContent;
        private Long brdCateNo;
        private List<MultipartFile> images;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long brdWriterNo;
        @NotNull private Long brdNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page {
        private Long pageNo;
        private Integer pageSize;
        private Long totalNo;
        private Collection<BrdDto.Read> brdList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ViewCount {
        private Long brdNo;
        private Long memNo;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        private String brdCateName;
        private BrdDto.Read board;
        private List<BrdImgDto.Read> images;

        private MemDto.Member member;
        private AddressDto.Read address;
        private List<CmtDto.Read> cmtList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList {
        private Long brdNo;
        private String brdCateName;
        private String brdTitle;
        private String brdContent;
        private Integer brdViews;
        private LocalDateTime brdCreatedAt;
        private String imgPath;
        private Integer brdLikeCount;
        private Boolean brdLikeCheck;
        private Integer cmtCount;
        private Boolean cmtCheck;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListData {
        private Long brdNo;
        @NotEmpty private String addressSi;
        @NotEmpty private String addressGu;
        @NotEmpty private String addressDong;
        @NotNull private Integer start;
        @NotNull private Integer end;
        private String keyword;
        private Long brdCateNo;
        private String brdCate;
        private Long brdWriterNo;
    }
}
