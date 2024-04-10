package com.chivalrycode.expensetracker.dto;

import jakarta.validation.constraints.NotEmpty;



public record UserDto(
        @NotEmpty(message = "Enter correct username and password")
        String username,
        @NotEmpty
        String password
) {
}
