package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Service.UserService;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;




    @PostMapping("/registerUser")
    public ResponseEntity userRegistration(@RequestBody UserRequestDto userRequestDto) throws Exception{

        try {
            UserResponseDto result = userService.addUser(userRequestDto);
            return new ResponseEntity(result,HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
