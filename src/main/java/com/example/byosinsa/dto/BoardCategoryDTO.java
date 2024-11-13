package com.example.byosinsa.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BoardCategoryDTO {

    private int cno;

    private String cName;
}
