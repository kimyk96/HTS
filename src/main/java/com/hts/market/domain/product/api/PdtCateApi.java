package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtCateApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdtCateApi {
    @Autowired
    private PdtCateApp pdtCateApp;

}
