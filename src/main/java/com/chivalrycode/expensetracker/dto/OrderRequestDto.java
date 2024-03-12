package com.chivalrycode.expensetracker.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderRequestDto {
    private String name;
    private Double price;
    private Integer quantity;

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}