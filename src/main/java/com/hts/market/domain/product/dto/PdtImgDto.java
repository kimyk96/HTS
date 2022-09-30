package com.hts.market.domain.product.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtImgDto {
    @Data
    public static class Create {
        private long pdtNo;
        private long imgNo;
        private String imgPath;
    }

    @Data
    public static class Update{
        private long pdtNo;
        private long imgNo;
        private String imgPath;
    }

    @Data
    public static class Read {
        private long rptNo;
        private long rptMemNo;
        private long rptPdtNo;
        private long rptMagNo;
        private LocalDateTime rptCreatedAt;
    }
}
