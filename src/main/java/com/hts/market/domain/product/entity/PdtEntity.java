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
    private Long pdtCateNo;
    private Long pdtSellerNo;
    private Long pdtAddressNo;
    private String pdtName;
    private String pdtDesc;
    private Integer pdtStatus;
    private Integer pdtPrice;
    private Integer pdtViews;
    private LocalDateTime pdtCreatedAt;
}
