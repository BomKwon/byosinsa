package com.example.byosinsa.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
public class BoardDTO {
    private int bno;

    private String bTitle;

    private String bContent;

    private String bWriter;

    private int cno;

    private int cName;

    // 조회수
    private int views;


    @Builder.Default
    private List<BoardImageDTO> boardImageDTOList = new ArrayList<>();
}
