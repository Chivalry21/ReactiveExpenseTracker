package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.dto.OrderRequestDto;
import com.chivalrycode.expensetracker.dto.OrderResponseDto;
import com.chivalrycode.expensetracker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    @PostMapping
    public OrderResponseDto save(@RequestBody OrderRequestDto dto){
        return  service.saveOrder(dto);
    }
    @PutMapping
    public OrderResponseDto update(OrderRequestDto dto,int id){
        return service.updateOrder(dto, id);
    }
    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable Long id){
        return service.getOrder(id);
    }
    /*private OrderServiceImpl orderService = new OrderServiceImpl();
    private final OrderServiceImpl orderService;

    @GetMapping("/{name}/{age}")
    public String D1(@PathVariable  String name,@PathVariable int age){
        return "Hello i am "+ name+ ", i am " + age+ "years old";
    }
    @GetMapping("/user/{}")
    public String D2(@PathVariable int id){
        return null;
    }
    @GetMapping
    public String D3(@RequestParam int age,@RequestParam String name){
        return "Hello i am "+ name+ ", i am " + age+ "years old";
    }

    @GetMapping("/all")
    public List<OrderResponseDto> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping
    public String createOrder(OrderRequestDto order){
        return "order created";
    }
    @DeleteMapping
    public String deleteOrder(){
        return "order Deleted Successfully";
    }
    @PatchMapping
    public String updateOrder(){
        return "order list updated";
    }*/



}
