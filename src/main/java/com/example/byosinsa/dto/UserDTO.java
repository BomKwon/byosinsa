package com.example.byosinsa.dto;

import com.example.byosinsa.constant.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class UserDTO {

    private int uno;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String nickname;

    @NotBlank
    private String address;

    @NotBlank
    private Role userRole;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;


}
