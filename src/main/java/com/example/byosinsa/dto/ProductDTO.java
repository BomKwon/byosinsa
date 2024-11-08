package com.example.byosinsa.dto;

import com.example.byosinsa.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class ProductDTO {

    private Long pno;

    @NotBlank
    private String pName;

    @NotBlank
    private String pDetail;

    @NotNull
    private int price;


    private static ModelMapper modelMapper = new ModelMapper();

    public Product newProduct(){

        return modelMapper.map(this, Product.class);
    }


}
