package com.example.recrutmenttool.Service.impl;


import com.example.recrutmenttool.Repositories.UserRepository;
import com.example.recrutmenttool.Service.UserService;
import com.example.recrutmenttool.Transformers.UserTransformer;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.exceptions.EmailAlreadyPresent;
import com.example.recrutmenttool.exceptions.UserExistsException;
import com.example.recrutmenttool.models.Admin;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) throws Exception {


//        checking username is that already present or not
        User checkUsername = userRepository.findByUsername(userRequestDto.getUsername());
        if(checkUsername!=null){
            throw new UserExistsException("This user name is not valid");
        }

//        checking emailId is that already present or not
        User checkEmailId = userRepository.findByEmailId(userRequestDto.getEmail());
        if(checkEmailId!=null){
            throw new EmailAlreadyPresent("This email is already present");
        }


//        extracting user
        User user = UserTransformer.ConvertEntity(userRequestDto);


//        saving userList for Admin
        Admin admin = new Admin();
        admin.getUserArrayList().add(user);


//        Saving user in DataBase
        userRepository.save(user);


//        transforming from user to responseDto
        UserResponseDto responseDto = UserTransformer.userToUserResponseDto(user);

        return responseDto;


    }
}
