package com.example.byosinsa.dto.search;

import com.example.byosinsa.entity.Board;
import com.example.byosinsa.entity.BoardCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@ToString
@NoArgsConstructor
public class BoardSearchDTO {

    private int bno;

    private String bTitle;

    private String bContent;

    private String bWriter;

    private BoardCategory boardCategory;

    // 조회수
    private int views;

    private int boardImgno;

    private String fileName;
    private String uuid;
    private String folderPath;
    private Board board;

    @QueryProjection
    public BoardSearchDTO(int bno, String bTitle, String bContent, String bWriter, BoardCategory boardCategory, int views, int boardImgno, String fileName, String uuid, String folderPath) {
        this.bno = bno;
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bWriter = bWriter;
        this.boardCategory = boardCategory;
        this.views = views;
        this.boardImgno = boardImgno;
        this.fileName = fileName;
        this.uuid = uuid;
        this.folderPath = folderPath;
    }







    public String getImageURL(){
        try {
            return URLEncoder
                    .encode(folderPath+"/"+uuid+"_"+fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }

    public String getThumbnailURL(){
        try {
            return URLEncoder
                    .encode(folderPath+"/" + "s_" +uuid+"_"+fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }
}
