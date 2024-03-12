package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.AuthResponseDto;
import com.chivalrycode.expensetracker.dto.LoginDto;
import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.exception.BadRequestException;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserResponseDto> signUp(UserDto userDto) throws BadRequestException;
    //User updateUser(User item);
     AuthResponseDto login(LoginDto dto);
    void logout();
}
