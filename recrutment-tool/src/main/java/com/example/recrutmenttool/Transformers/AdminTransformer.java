package com.example.recrutmenttool.Transformers;

import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.models.Admin;

public class AdminTransformer {

    public static Admin convertEntity(AdminRequestDto adminRequestDto){

        Admin admin = Admin.builder()
                .username(adminRequestDto.getUsername())
                .email(adminRequestDto.getEmail())
                .password(adminRequestDto.getPassword())
                .build();

        return admin;
    }


    public static AdminResponseDto adminToResponseDto(Admin admin){
        AdminResponseDto responseDto = AdminResponseDto.builder()
                .username(admin.getUsername())
                .email(admin.getEmail())
                .build();
        return  responseDto;
    }
}
