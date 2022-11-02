package com.hts.market.global.api;

import com.hts.market.global.app.RptMsgApp;
import com.hts.market.global.dto.RptMsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rpt-msg")
public class RptMsgApi {
    @Autowired
    RptMsgApp rptMsgApp;

    @GetMapping("")
    public ResponseEntity<List<RptMsgDto>> findAll(){
        return ResponseEntity.ok().body(rptMsgApp.findAll());
    }
}
