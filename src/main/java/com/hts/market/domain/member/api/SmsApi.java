package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.SmsApp;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/sms")
public class SmsApi {
    @Autowired SmsApp smsApp;

    @GetMapping("/verify")
    public ResponseEntity<String> sendSMS(Integer memPhone) throws CoolsmsException {
        // 사용자에게 인증코드를 발송 & 인증코드는 ajax response로 리턴
        return ResponseEntity.ok().body(smsApp.send(memPhone));
    }
}
