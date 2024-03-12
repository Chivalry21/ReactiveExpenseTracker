package com.chivalrycode.expensetracker.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CategoryResponseDto {
    private String name;
    private Long id;
}
