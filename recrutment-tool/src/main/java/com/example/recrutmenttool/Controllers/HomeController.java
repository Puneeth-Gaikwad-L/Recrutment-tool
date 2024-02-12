package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Security.JwtHelperClass;
import com.example.recrutmenttool.Service.AdminService;
import com.example.recrutmenttool.Service.UserService;
import com.example.recrutmenttool.dto.requestDto.AdminRequestDto;
import com.example.recrutmenttool.dto.requestDto.UserRequestDto;
import com.example.recrutmenttool.dto.requestDto.loginRequestDto;
import com.example.recrutmenttool.dto.responseDto.AdminResponseDto;
import com.example.recrutmenttool.dto.responseDto.UserResponseDto;
import com.example.recrutmenttool.dto.responseDto.loginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
     private UserDetailsService userDetailsService;


    @Autowired
    private JwtHelperClass helper;

    private Logger logger = (Logger) LoggerFactory.getLogger(HomeController.class);



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


    @PostMapping
    public ResponseEntity login(@RequestBody loginRequestDto request){

        this.doAuthenticate(request.getUsername(),request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        loginResponseDto response = loginResponseDto.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
