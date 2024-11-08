package com.example.byosinsa.service;

import com.example.byosinsa.dto.ProductDTO;
import com.example.byosinsa.entity.Product;
import com.example.byosinsa.entity.ProductImg;
import com.example.byosinsa.repository.ProductImgRepository;
import com.example.byosinsa.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ProductService {

    private ProductRepository productRepository;
    private ProductImgRepository productImgRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    //등록
    public int productRegister(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        Product result = productRepository.save(product);

        productDTO.getProductImageDTOList().forEach(imgDTO -> {
            ProductImg productImg = ProductImg.builder()
                    .filename(imgDTO.getFileName())
                    .uuid(imgDTO.getUuid())
                    .product(product)
                    .mainImg(imgDTO.getMainImg())
                    .build();

            productImgRepository.save(productImg);
        });

        int pno = result.getPno();

        return pno;
    }

    //목록


    //읽기

    //수정

    //삭제



}
