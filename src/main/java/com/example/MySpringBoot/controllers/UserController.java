package com.example.MySpringBoot.controllers;

import com.example.MySpringBoot.Service.UserService;
import com.example.MySpringBoot.advice.ApiError;
import com.example.MySpringBoot.dto.SignupDto;
import com.example.MySpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public String check(){
        return "Hello World";
    }
    @GetMapping("/auth/")
    public String hello() {
        return "Hello World you logged in!";
    }

    @GetMapping("/test-error")
    public ResponseEntity<ApiError> testError() {
        return new ResponseEntity<>(new ApiError("This is a test error", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/admin")
    public String admin() {
        return "Hello World this is admin";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello World this is user";
    }

    @GetMapping("/dev")
    public String dev() {
        return "Hello World this is dev";
    }

//    @PostMapping
//    public void registerUser( @RequestBody SignupDto user) {
//        userService.createUser(user);
//    }
}
