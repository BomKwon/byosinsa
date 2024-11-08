package com.example.byosinsa.service;

import com.example.byosinsa.dto.ProductDTO;
import com.example.byosinsa.entity.Product;
import com.example.byosinsa.repository.ProductImgRepository;
import com.example.byosinsa.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ProductService {

    private ProductRepository productRepository;
    private ProductImgRepository productImgRepository;

    //등록



    //읽기

    //목록

    //수정

    //삭제



}
