package com.example.recrutmenttool.Service.impl;


import com.example.recrutmenttool.Enum.AccountStatus;
import com.example.recrutmenttool.Repositories.AdminRepository;
import com.example.recrutmenttool.Repositories.UserRepository;
import com.example.recrutmenttool.Service.UserService;
import com.example.recrutmenttool.Transformers.UserTransformer;
import com.example.recrutmenttool.dto.requestDto.ResetDto;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.exceptions.*;
import com.example.recrutmenttool.models.Admin;
import com.example.recrutmenttool.models.Client;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) throws Exception {


       //checking username is that already present or not
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDto.getUsername());
        if(optionalUser.isPresent()){
            throw new UserExistsException("This user name is not valid");
        }

        // checking emailId is that already present or not
        User checkEmailId = userRepository.findByEmailId(userRequestDto.getEmail());
        if(checkEmailId!=null){
            throw new EmailAlreadyPresent("This email is already present");
        }


       //extracting user
        User user = UserTransformer.ConvertEntity(userRequestDto);


       // saving userList for Admin
        Optional<Admin> optionalAdmin=adminRepository.findById(1);
        Admin admin=optionalAdmin.get();
        user.setAdmin(admin);

        List<User> users = admin.getUserArrayList();
        if(users==null) {
            users = new ArrayList<>();
        }
        users.add(user);

       //Saving user in DataBase
        userRepository.save(user);

       //transforming from user to responseDto
        UserResponseDto responseDto = UserTransformer.userToUserResponseDto(user);

        return responseDto;

    }


    @Override
    public String update(String username, UserRequestDto userRequestDto) throws Exception{

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
            throw new InvalidUserNameException("This is Invalid Username");
        }
        User user = optionalUser.get();

        if(user.getAccountStatus().equals(AccountStatus.PENDING) || user.getAccountStatus().equals(AccountStatus.INACTIVE)){
            throw new InvalidAccountStatusException("Your Account Status is valid to make any updates");
        }

        if(userRequestDto.getUsername()!=null){
            user.setUsername(userRequestDto.getUsername());
        }
        if(userRequestDto.getPassword()!=null){
            user.setPassword(userRequestDto.getPassword());
        }
        if(userRequestDto.getOrganization()!=null){
            user.setOrganization(userRequestDto.getOrganization());
        }
        if(userRequestDto.getEmail()!=null){
            userRequestDto.setEmail(userRequestDto.getEmail());
        }

        userRepository.save(user);
        return " Given user information successfully updated";
    }

    @Override
    public String deleteUser(String username) throws Exception {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
           throw new InvalidUserNameException("This is a invalid username");
        }
        User user = optionalUser.get();

        userRepository.delete(user);
        return "User is deleted successfully";
    }

    @Override
    public String changePassword(ResetDto resetDto) throws Exception {
        Optional<User> optionalUser = userRepository.findByUsername(resetDto.getUsername());
        if(!optionalUser.isPresent()){
            throw new UserNotPresentException("user not found");
        }

        User user = optionalUser.get();
        if(!user.getSecurityQuestion().equals(resetDto.getSecurityQuestions())){
            throw new NotMatchedException("this Security question are not same");
        }
        user.setPassword(resetDto.getNewPassword());
        userRepository.save(user);


        return "your password updated";
    }

//    @Override
//    public List<Client> getClients(String username) {
//        Optional<User> optionalUser= userRepository.findByUsername(username);
//
//       User user = optionalUser.get();
//       return user.getClientList();
//    }


}
