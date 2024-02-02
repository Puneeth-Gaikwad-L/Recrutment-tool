package com.example.recrutmenttool.Service.impl;

import com.example.recrutmenttool.Repositories.AdminRepository;
import com.example.recrutmenttool.Service.AdminService;
import com.example.recrutmenttool.Transformers.AdminTransformer;
import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) throws Exception {


        Admin admin = AdminTransformer.convertEntity(adminRequestDto);

        adminRepository.save(admin);

        AdminResponseDto Result = AdminTransformer.adminToResponseDto(admin);

        return Result;
    }
}
