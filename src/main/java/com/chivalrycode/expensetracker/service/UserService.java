package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.dto.RegUserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.exception.BadRequestException;
import com.chivalrycode.expensetracker.model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponseDto> signUp(RegUserDto userDto) throws BadRequestException;
    User getUser(UserDto userDto);
    //User updateUser(User item);
 //  Mono<AuthResponseDto> login(LoginDto dto);
    //Mono<Void> logout();
}
