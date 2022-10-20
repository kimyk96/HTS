package com.hts.market.domain.board.app;

import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.exception.ImgFileNotFoundException;
import com.hts.market.domain.board.repo.BrdImgRepo;
import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.exception.ProductImageSaveFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BrdImgApp {

    @Autowired
    BrdImgRepo brdImgRepo;
    //이미지 작성
    public Integer save(BrdImgDto.FileList dto) throws IOException{
        Long i = 0L;
        for(MultipartFile files: dto.getFiles()){
            try {
//                이미지 불러올때 쓰는 메소드 3-4줄까진 복붙
                String fileName = "board/" + dto.getBrdNo() + "-" + ++i + "." + files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                String imgSaveDir = new File("").getAbsolutePath() + "\\" + "/images/";
                File brdImg = new File(imgSaveDir + fileName);
                brdImg.getParentFile().mkdirs();
                files.transferTo(brdImg);
                brdImgRepo.save(BrdImgDto.Create.builder().brdNo(dto.getBrdNo()).imgNo(i).imgPath(fileName).build());
            } catch (IOException e){
                System.out.println(e);
                throw new ImgFileNotFoundException();
            }
        }
        return 1;

    };

//    이미지 수정
    public Integer update(BrdImgDto.FileList dto) throws IOException{
        List<BrdImgDto.Read> oldList = brdImgRepo.searchOfBrdNo(dto.getBrdNo());
        for(BrdImgDto.Read deleteImg : oldList){
            String imgUpdateDir = new File("").getAbsolutePath() + "\\" + "/images/";
            File file = new File(imgUpdateDir + deleteImg.getImgPath());
            boolean result = file.delete();
        }
        brdImgRepo.deleteAll(dto.getBrdNo());
        save(dto);
        return 1;
    };

    //이미지삭제
    public Integer delete(BrdImgDto.Delete dto){
        return brdImgRepo.delete(dto);
    };

    //대표이미지 적용
    public String findMainImg(Long brdNo){return null;};

    //이미지 전체 삭제

    public Integer deleteAll (Long brdNo)throws IOException{
        List<BrdImgDto.Read> oldList = brdImgRepo.searchOfBrdNo(brdNo);
        for(BrdImgDto.Read deleteImg : oldList){
            String imgUpdateDir = new File("").getAbsolutePath() + "\\" + "/images/";
            File file = new File(imgUpdateDir + deleteImg.getImgPath());
            boolean result = file.delete();
        }
        return brdImgRepo.deleteAll(brdNo);
    }




}
