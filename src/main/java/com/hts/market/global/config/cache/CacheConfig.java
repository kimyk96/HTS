package com.hts.market.global.config.cache;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    // 예시 - service 단에서 메소드에 사용
//    // 메소드를 캐싱한다.
//    @Cacheable(value="view", key="#productNo")
//    public Product view(int productNo) {
//        log.info("view 호출");
//        return new Product(productNo, "이름입니다");
//    }
//
//    // 캐시를 취소한다.
//    // change 메소드가 실행되면 , view 캐시를 취소해라.
//    @CacheEvict(value="view", allEntries=true)
//    public void change(int productNo) {
//        log.info("캐시 취소");
//    }
}
