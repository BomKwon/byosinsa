package com.example.byosinsa.dto;

import com.example.byosinsa.entity.Board;
import lombok.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardImageDTO {

    private int boardImgno;
    private String fileName;
    private String uuid;
    private String folderPath;
    private Board board;

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
