package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Service.AdminService;
import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/addAdmin")
    public ResponseEntity registerAdmin(@RequestBody AdminRequestDto adminRequestDto)throws Exception{
        try{
            AdminResponseDto Result = adminService.addAdmin(adminRequestDto);
            return new ResponseEntity(Result,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getUserByUserName/{username}")
    public ResponseEntity getUserByUserName(@PathVariable String username) throws Exception{

        try{
            User user =adminService.getUserByUserName(username);

            return new ResponseEntity(user,HttpStatus.ACCEPTED);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("updateAccountStatusToActive/{username}")
    public ResponseEntity updateAccountStatus(@PathVariable String username) throws Exception{
        try {
            String result = adminService.updateAccount(username);
            return new ResponseEntity(result, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
