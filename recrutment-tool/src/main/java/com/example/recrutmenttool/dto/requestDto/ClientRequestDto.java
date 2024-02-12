package com.example.recrutmenttool.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    private String username;
    private String email;
    private String password;
    private String organization;
}
