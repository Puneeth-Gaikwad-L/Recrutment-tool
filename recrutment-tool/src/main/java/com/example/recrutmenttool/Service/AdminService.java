package com.example.recrutmenttool.Service;

import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.models.User;

import java.util.List;


public interface AdminService {
    public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto)throws Exception;

    public User getUserByUserName(String username)throws Exception;


    String updateAccount(String username) throws Exception;
}
