package com.chivalrycode.expensetracker.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class OrderResponseDto {
    private long id;
    private String name;
    private Double price;
    private Integer quantity;

}
