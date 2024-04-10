package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.dto.AuthResponseDto;
import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.RegUserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserResponseDto> createUser(@Valid @RequestBody RegUserDto userDto) {
        return authService.signUp(userDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<AuthResponseDto> login(@Valid @RequestBody UserDto userDto) {
        System.out.println(userDto);
        return Mono.empty();
       // return authService.login(loginDto);
    }
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> logout() {
       return Mono.empty();
        //return authService.logout();
    }
}


