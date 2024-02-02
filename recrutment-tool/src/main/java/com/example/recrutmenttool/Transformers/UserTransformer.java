package com.example.recrutmenttool.Transformers;

import com.example.recrutmenttool.Enum.AccountStatus;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.models.User;

public class UserTransformer {

    public static User ConvertEntity(UserRequestDto userRequestDto){

        User user = User.builder()
                .username(userRequestDto.getUsername())
                .emailId(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
//                .password(setPassword(userRequestDto.getPassword()))
                .organization(userRequestDto.getOrganization())
                .accountStatus(AccountStatus.valueOf("PENDING"))
                .build();

        return user;

    }

    public static UserResponseDto userToUserResponseDto(User user){

        UserResponseDto userResponseDto = UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmailId())
                .build();

        return userResponseDto;
    }

//    public static String setPassword(String plainPassword){
//        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
//        String password = hashedPassword;
//        return password;
//    }

}
