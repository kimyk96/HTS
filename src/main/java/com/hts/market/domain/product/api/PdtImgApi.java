package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtImgApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdtImgApi {
    @Autowired
    private PdtImgApp pdtImgApp;
}