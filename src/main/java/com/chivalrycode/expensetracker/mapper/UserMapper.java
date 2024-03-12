package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.UserDto;
import com.chivalrycode.expensetracker.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
    }
}
