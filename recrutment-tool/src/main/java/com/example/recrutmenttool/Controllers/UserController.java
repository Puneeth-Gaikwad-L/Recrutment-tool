package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Service.UserService;
import com.example.recrutmenttool.dto.requestDto.ResetDto;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.requestDto.loginRequestDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.models.Client;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
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

    @PutMapping("/updateFields/{username}")
    public ResponseEntity updateFields(@PathVariable String username, @RequestBody UserRequestDto userRequestDto){

        try{
            String result = userService.update(username,userRequestDto);
            return new ResponseEntity(result,HttpStatus.ACCEPTED);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam String username) throws Exception{
        try{
            String Result = userService.deleteUser(username);
            return new ResponseEntity(Result,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }




    @PutMapping("/forgetPassword")
    public ResponseEntity resetPassword(@RequestBody ResetDto resetDto) throws Exception{
        try{
            String Result = userService.changePassword(resetDto);
            return new ResponseEntity(Result,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }







}
