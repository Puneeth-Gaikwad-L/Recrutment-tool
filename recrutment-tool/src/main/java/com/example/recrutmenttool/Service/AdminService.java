package com.example.recrutmenttool.Service;

import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import org.springframework.stereotype.Service;


public interface AdminService {
    public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto)throws Exception

            ;
}
