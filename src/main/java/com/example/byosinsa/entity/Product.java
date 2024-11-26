package com.example.byosinsa.entity;

import com.example.byosinsa.constant.ProductStatus;
import com.example.byosinsa.entity.base.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; //상품번호

    @Column(length = 100, nullable = false)
    private String pName; //상품명

    @Column(length = 100, nullable = false)
    private String brand; //브랜드명

    @Lob //텍스트많이
    @Column(nullable = false)
    private String pDetail; //상세정보

    @Column(nullable = false)
    private String category; //품목

    @Column(name = "price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int discount; //할인률

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus; //상품상태


}
