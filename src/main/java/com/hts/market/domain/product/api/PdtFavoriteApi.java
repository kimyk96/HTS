package com.hts.market.domain.product.api;

import com.hts.market.domain.product.app.PdtFavoriteApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdtFavoriteApi {
    @Autowired
    private PdtFavoriteApp pdtFavoriteApp;
}
