package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.RegUserDto;
import com.chivalrycode.expensetracker.dto.UserResponseDto;
import com.chivalrycode.expensetracker.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(RegUserDto dto) {
        return User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
    }

    public UserResponseDto toUserResponseDto(User user){
        return new UserResponseDto(user.getName(),"");
    }
}
