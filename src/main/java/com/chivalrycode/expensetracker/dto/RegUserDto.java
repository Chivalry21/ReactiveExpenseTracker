package com.chivalrycode.expensetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegUserDto {
    @NotBlank(message = "Please provide your name")//this field can not be empty
    private String name;
    @NotBlank(message = "Enter your username")
    @Size(min = 6, message = "username must be 6 characters long")
    @Size(max = 10, message = "username must be 10 characters long")
    private String username;
    @NotBlank
    private String password;
}
