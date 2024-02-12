package com.example.recrutmenttool.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResetDto {
    private String securityQuestions;
    private String username;
    private String newPassword;
}
