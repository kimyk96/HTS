package com.hts.market.domain.member.app;

import com.hts.market.domain.member.repo.MemRepo;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class SmsApp {
    // 인증코드 발송
    public String send(String phoneNumber) throws CoolsmsException {
        // 랜덤 4자리 숫자 생성
        Random random  = new Random();
        Integer number = random.nextInt(9999);
        String randomNumber = String.format("%04d", number);

        // 테스트 시에는 콘솔로그로 확인, 아래 주석 풀면 코드 잘 보내짐
        System.out.println(randomNumber);

//        // 메세지 발송
//        String apiKey = "NCSYNLELHDWX1Q70";
//        String apiSecret = "AIMXC2MAT4Y8MMVDBZAVNPIOZ3KSBRJR";
//        Message coolsms = new Message(apiKey, apiSecret);
//
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("to",   phoneNumber);
//        map.put("from", "01027249409");
//        map.put("type", "SMS");
//        map.put("text", "인증번호 : [ " + randomNumber + " ]");
//        map.put("app_version", "HTS 1.0");
//        try {
//            JSONObject result = (JSONObject) coolsms.send(map);
//            System.out.println(result);
//        } catch (CoolsmsException e) {
//           throw new CoolsmsException(e.getMessage(), e.getCode());
//        }
        return randomNumber;
    }
}
