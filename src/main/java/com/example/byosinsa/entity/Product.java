package com.example.byosinsa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(length = 100)
    private String pName;

    @Column(length = 50000)
    private String pDetail;

    private String category;

    private int price;

    private int discount;




}
