package com.example.byosinsa.dto;

import lombok.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ImgDTO {

    private String fileName;
    private String uuid;
    private String mainImg;
//    private String url; 빼기

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    public ImgDTO(String fileName, String uuid) {
        this.fileName = fileName;
        this.uuid = uuid;
    }

    public String getImageURL(){
        try {
            return URLEncoder
                    .encode(uuid+"_"+fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }

    public String getThumbnailURL(){
        try {
            return URLEncoder
                    .encode("s_" +uuid+"_"+fileName,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }
}
