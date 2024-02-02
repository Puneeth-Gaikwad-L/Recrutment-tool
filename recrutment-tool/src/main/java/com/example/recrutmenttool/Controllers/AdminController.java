package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Service.AdminService;
import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/addAdmin")
    public ResponseEntity registerAdmin(AdminRequestDto adminRequestDto)throws Exception{
        try{
            AdminResponseDto Result = adminService.addAdmin(adminRequestDto);
            return new ResponseEntity(Result,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
