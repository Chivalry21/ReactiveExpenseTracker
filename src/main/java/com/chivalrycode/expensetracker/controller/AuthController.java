package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.dto.AuthResponseDto;
import com.chivalrycode.expensetracker.dto.LoginDto;
import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserDto userDto) {
        return authService.signUp(userDto);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AuthResponseDto login(@Valid @RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        return authService.login(loginDto);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
        authService.logout();
    }
}


