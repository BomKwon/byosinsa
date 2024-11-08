package com.example.byosinsa.repository;

import com.example.byosinsa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    /*상품명 검색*/
    Page<Product> findByPNameContaining(String keyword, Pageable pageable);

}
