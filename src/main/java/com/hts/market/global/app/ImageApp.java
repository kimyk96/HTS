package com.hts.market.global.app;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ImageApp {

    // 이미지 불러오기
    public ResponseEntity<byte[]> findByPath(String dir, String img) {
        File file = new File(new File("").getAbsolutePath() + "\\/images/", dir + "/" + img);
        if (!file.exists()) {
            File defaultImg = new File(new File("").getAbsolutePath() + "\\/src/main/resources/static/img/example/", dir + "/default.png");
            try {
                return ResponseEntity.ok().body(Files.readAllBytes(defaultImg.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(getMediaType(img));
        headers.add("Content-Disposition", "inline;filename=" + img);
        try {
            return ResponseEntity.ok().headers(headers).body(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 이미지 마임 타입 확인
    private MediaType getMediaType(String imgPath) {
        Integer position = imgPath.lastIndexOf(".");
        String ext = imgPath.substring(position + 1).toLowerCase();
        if (ext.equals("JPG")) {
            return MediaType.IMAGE_JPEG;
        }
        if (ext.equals("PNG")) {
            return MediaType.IMAGE_PNG;
        }
        if (ext.equals("GIF")) {
            return MediaType.IMAGE_GIF;
        }
        return null;
    }
}
