package com.example.byosinsa.entity;

import com.example.byosinsa.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

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
