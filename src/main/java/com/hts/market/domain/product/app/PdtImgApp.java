package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.exception.ProductImageSaveFailException;
import com.hts.market.domain.product.repo.PdtImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PdtImgApp {
    @Autowired
    private PdtImgRepo pdtImgRepo;

    // 이미지 저장
    public Integer save(PdtImgDto.ListFile dto) throws IOException {
       Long i = 0L;
       for(MultipartFile files: dto.getFiles()){
           try {
               String fileName = "product/" + dto.getPdtNo() + "-" + ++i + "." + files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
               String imgSaveDir = new File("").getAbsolutePath() + "\\" + "/images/";
               File pdtImg = new File(imgSaveDir + fileName);
               pdtImg.getParentFile().mkdirs();
               files.transferTo(pdtImg);
               pdtImgRepo.save(PdtImgDto.Create.builder().pdtNo(dto.getPdtNo()).imgNo(i).imgPath(fileName).build());
           } catch (IOException e){
               System.out.println(e);
               throw new ProductImageSaveFailException();
           }
       }
       return 1;
    }

    // 이미지 수정
    public Integer update(PdtImgDto.ListFile dto) throws IOException{;
        List<PdtImgDto.Read> oldList = pdtImgRepo.searchOfPdtNo(dto.getPdtNo());
        for(PdtImgDto.Read deleteImg : oldList){
            String imgUpdateDir = new File("").getAbsolutePath() + "\\" + "/images/";
            File file = new File(imgUpdateDir + deleteImg.getImgPath());
            boolean result = file.delete();
        }
        pdtImgRepo.deleteAll(dto.getPdtNo());
        Integer update = save(dto);
        return 1;
    }

    // 이미지 개별삭제
    public Integer deleteByImgNo(PdtImgDto.Delete dto){
        return pdtImgRepo.deleteByImgNo(dto);
    }

    // 이미지 전체삭제
    public Integer deleteAll(Long pdtNo){
        return pdtImgRepo.deleteAll(pdtNo);
    }

}
