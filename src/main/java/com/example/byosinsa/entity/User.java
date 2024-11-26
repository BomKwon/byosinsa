package com.example.byosinsa.entity;

import com.example.byosinsa.constant.Role;
import com.example.byosinsa.entity.base.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uno;

    @Column(unique = true)
    private String email;

    private String password;

    private String name;

    private String phone;

    private String nickname;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role userRole;


}
