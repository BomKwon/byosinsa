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

    private Long cno;

    private Long cName;

    // 조회수
    private Long views;


    @Builder.Default
    private List<BoardImageDTO> boardImageDTOList = new ArrayList<>();
}
