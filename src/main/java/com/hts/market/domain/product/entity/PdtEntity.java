package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class PdtEntity {
    private Long pdtNo;
    private String pdtName;
    private String pdtStatus;
    private String pdtDesc;
    private Integer pdtPrice;
    private Integer pdtViews;
    private Long pdtAddressNo;
    private Long pdtCateNo;
    private Long pdtSellerNo;
    private LocalDateTime pdtCreatedAt;
}
