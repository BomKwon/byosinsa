package com.example.byosinsa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pino;

    private String filename;

    private String uuid;

    private String mainImg;

//    private String url;

    @ManyToOne
    @JoinColumn(name = "pno")
    private Product product;

}
