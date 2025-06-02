package com.example.MySpringBoot.controllers;

import com.example.MySpringBoot.Service.AuthService;
import com.example.MySpringBoot.Service.JwtService;
import com.example.MySpringBoot.Service.UserService;
import com.example.MySpringBoot.dto.LoginDto;
import com.example.MySpringBoot.dto.LoginResponseDto;
import com.example.MySpringBoot.dto.SignupDto;
import com.example.MySpringBoot.dto.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AuthController {


    private final UserService userService;
    private final AuthService authService;


    public AuthController(UserService userService, AuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserDto> register(@RequestBody SignupDto user) {
        System.out.println("authController -> user "+ user);
        UserDto createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }



    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto user, HttpServletResponse response) {
        LoginResponseDto result = authService.login(user);
        Cookie cookie = new Cookie("refreshToken", result.getRefreshToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<LoginResponseDto> refresh (HttpServletRequest request){
        System.out.println("authController -> refresh");
     String refreshToken =    Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("refreshToken"))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(()-> new AuthenticationServiceException("Refresh Token Could no be found in the cookies"));
     LoginResponseDto loginResponseDto = authService.refreshToken(refreshToken);
     return ResponseEntity.ok(loginResponseDto);
    }

}
