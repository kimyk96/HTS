package com.hts.market.domain.product.app;

import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtFavoriteApp {
    @Autowired
    private PdtFavoriteRepo pdtFavoriteRepo;
}
