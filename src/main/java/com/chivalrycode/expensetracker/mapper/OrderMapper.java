package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.OrderRequestDto;
import com.chivalrycode.expensetracker.dto.OrderResponseDto;
import com.chivalrycode.expensetracker.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
   public Order toOrder(OrderRequestDto dto){
        return Order.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
    public OrderResponseDto toOrderResponseDto(Order order){
       return OrderResponseDto.builder()
               .id(order.getId())
               .name(order.getName())
               .price(order.getPrice())
               .quantity(order.getQuantity())
               .build();
    }
}
