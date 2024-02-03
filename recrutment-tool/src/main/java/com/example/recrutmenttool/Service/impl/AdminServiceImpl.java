package com.example.recrutmenttool.Service.impl;

import com.example.recrutmenttool.Enum.AccountStatus;
import com.example.recrutmenttool.Repositories.AdminRepository;
import com.example.recrutmenttool.Repositories.UserRepository;
import com.example.recrutmenttool.Service.AdminService;
import com.example.recrutmenttool.Transformers.AdminTransformer;
import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.exceptions.UserNotPresentException;
import com.example.recrutmenttool.models.Admin;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) throws Exception {

        Admin admin = AdminTransformer.convertEntity(adminRequestDto);

        adminRepository.save(admin);

        AdminResponseDto Result = AdminTransformer.adminToResponseDto(admin);

        return Result;
    }

    @Override
    public User getUserByUserName(String username) throws Exception {

        Optional<User> optionalUser  = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
            throw new UserNotPresentException("This user name is not present");
        }
        User user = optionalUser.get();
        return user;

    }

    @Override
    public String updateAccount(String username)throws Exception {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
            throw new UserNotPresentException("This username is not valid");
        }
        User user = optionalUser.get();

        user.setAccountStatus(AccountStatus.ACTIVE);
        userRepository.save(user);
        return "Account status updated from Pending to Active";
    }


}
