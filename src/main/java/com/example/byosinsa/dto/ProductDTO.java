package com.example.byosinsa.dto;

import com.example.byosinsa.constant.ProductStatus;
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
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
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
    @NotNull(message = "상품명을 입력해주세요.")
    private String pName;

    @NotBlank
    @NotNull(message = "상품명을 입력해주세요.")
    private String brand; //나중엔 자동입력으로 할거임

    @NotBlank
    @NotNull(message = "상세정보를 입력해주세요.")
    private String pDetail;

    @NotBlank
    @NotNull(message = "카테고리를 선택해주세요.")
    private String category;

    @NotNull
    @NotNull(message = "가격을 입력해주세요.")
    private int price;

    private int discount;

    @NotNull
    @NotNull(message = "재고수량을 입력해주세요.")
    private int stockNumber; //재고수량

    private ProductStatus productStatus; //상품상태

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    //상품 이미지
    @Builder.Default
    private List<ImgDTO> productImageDTOList = new ArrayList<>();



    // 메소드  EntityToDto // DtoToEntity
    private static ModelMapper modelMapper = new ModelMapper();
    public Product newProduct(){

        return modelMapper.map(this, Product.class);
    }
    public static ProductDTO of(Product product){

        return modelMapper.map(product, ProductDTO.class);
    }
    //ProductImgIds
    //이미 저장되어서 수정할때 불러온 사진들의 아이디 삭제할 이미지들
    private List<Integer> ProductImgIds = new ArrayList<>();

}
