package com.example.recrutmenttool.Service;

import com.example.recrutmenttool.dto.requestDto.ResetDto;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.exceptions.UserExistsException;
import com.example.recrutmenttool.models.Client;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.util.List;

public interface UserService{

    public UserResponseDto addUser(UserRequestDto userRequestDto) throws Exception;

    String update(String username, UserRequestDto userRequestDto) throws Exception;

    String deleteUser(String username) throws Exception;

    String changePassword(ResetDto resetDto)throws Exception;

//    List<Client> getClients(String username);
}
