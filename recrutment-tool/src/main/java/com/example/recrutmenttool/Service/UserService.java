package com.example.recrutmenttool.Service;

import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.exceptions.UserExistsException;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto userRequestDto) throws Exception;
}
