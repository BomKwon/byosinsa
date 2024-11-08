package com.example.byosinsa.repository;

import com.example.byosinsa.entity.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImgRepository extends JpaRepository<ProductImg, Integer> {

    List<ProductImg> findByProduct_Pno(int pno);
    //aa
    Long deleteByProduct_Pno(int pno);


}
