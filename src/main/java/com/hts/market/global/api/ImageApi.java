package com.hts.market.global.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/images")
public class ImageApi {
    @GetMapping(path="/{dir}/{img}", produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> images(@PathVariable String dir, @PathVariable String img) {
        File file = new File(new File("").getAbsolutePath() + "\\" + "/images/", dir + "/" + img);
        System.out.println(file.getPath());
        if(file.exists()==false){
            return null;
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

    private MediaType getMediaType(String imgPath) {
        Integer position = imgPath.lastIndexOf(".");
        String ext = imgPath.substring(position+1).toLowerCase();
        if(ext.equals("JPG")){
            return MediaType.IMAGE_JPEG;
        }
        if(ext.equals("PNG")){
            return MediaType.IMAGE_PNG;
        }
        if(ext.equals("GIF")){
            return MediaType.IMAGE_GIF;
        }
        return null;
    }
}
