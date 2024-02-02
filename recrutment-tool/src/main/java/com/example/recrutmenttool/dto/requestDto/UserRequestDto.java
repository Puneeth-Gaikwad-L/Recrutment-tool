package com.example.recrutmenttool.dto.requestDto;

import com.example.recrutmenttool.Enum.AccountStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private String organization;

}
