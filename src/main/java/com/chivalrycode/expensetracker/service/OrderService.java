package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.OrderRequestDto;
import com.chivalrycode.expensetracker.dto.OrderResponseDto;
import com.chivalrycode.expensetracker.model.Order;

import java.util.List;

public interface OrderService {
      List<OrderResponseDto> getAllOrder();
      OrderResponseDto getOrder(Long id);
      OrderResponseDto saveOrder(OrderRequestDto data);
      String deleteOrder(int id);
      OrderResponseDto updateOrder(OrderRequestDto data,int id);
      String saveAllOrder(List<OrderRequestDto> items);
      List<Order> deleteAllOrder();


     //Todo list:getAllOrder(),getOrder(),saveOrder(),deleteOrder(),updateOrder().



}
