package com.hts.market.domain.transaction.api;

import com.hts.market.domain.transaction.app.ReviewApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/review")
public class ReviewApi {
    @Autowired ReviewApp reviewApp;
    //public ResponseEntity<>save(){
    // return null;
}