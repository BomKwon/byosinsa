package com.example.byosinsa.entity;

import com.example.byosinsa.entity.base.Base;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Member;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Searched extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;

    private String SearchKeyword;

    @ManyToOne
    @JoinColumn(name = "uno")
    private Users users;


}
