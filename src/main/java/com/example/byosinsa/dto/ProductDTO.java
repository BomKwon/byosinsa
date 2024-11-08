package com.example.byosinsa.dto;

import com.example.byosinsa.entity.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class ProductDTO {

    private int pno;

    @NotBlank
    private String pName;

    @NotBlank
    private String pDetail;

    @NotBlank
    private String category;

    @NotNull
    private int price;

    private int discount;

    //상품 이미지
    @Builder.Default
    private List<ImgDTO> productImageDTOList = new ArrayList<>();


}
