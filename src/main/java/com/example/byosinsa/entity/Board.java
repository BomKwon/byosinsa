package com.example.byosinsa.entity;

import com.example.byosinsa.entity.base.Base;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert //기본값 객체생성할때 필요한거
public class Board extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    private String bTitle;

    private String bContent;

    private String bWriter;

    @ManyToOne
    @JoinColumn(name = "cno")
    private BoardCategory boardCategory;



    //기본값
    @ColumnDefault("0")
    private int views;
}
