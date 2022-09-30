package com.hts.market.domain.board.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrdImg {

    @Data
    public static class Create {
        private Integer brdImgNo;
    }

    public static class Update{
        private Integer brdImgNo;
        private Integer brdNo;
        private String brdWriter;
    }
    public static class Delete{
        private Integer brdImgNo;
        private Integer brdNo;
        private String brdWriter;//작성자가 아니면 삭제할수,,,,,,,,,
    }

}
