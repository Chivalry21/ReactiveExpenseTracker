package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.OrderRequestDto;
import com.chivalrycode.expensetracker.dto.OrderResponseDto;
import com.chivalrycode.expensetracker.mapper.OrderMapper;
import com.chivalrycode.expensetracker.model.Order;
import com.chivalrycode.expensetracker.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    @Override
    public OrderResponseDto getOrder(Long id) {
        Optional<Order>order =orderRepository.findById(id);
        return order.map(orderMapper::toOrderResponseDto).orElse(null);

    }
    @Override
    public OrderResponseDto saveOrder(OrderRequestDto data) {
        Order order = orderRepository.save(orderMapper.toOrder(data));
        return orderMapper.toOrderResponseDto(order);



        /*System.out.println(data);
        Order order = new Order();
        order.setName(data.getName());
        order.setPrice(data.getPrice());
        order.setQuantity(data.getQuantity());

        Order order1 = orderRepository.save(Order.builder()
                        .name(data.getName())
                        .price(data.getPrice())
                        .quantity(data.getQuantity())
                .build());
        /*Order order1 = orderRepository.save(order);
        System.out.println(order1);*/

       /*ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(4,6,3,7));
        scores.add(8);
        int[] sc = {3,4,46,7,9,8};
        System.out.println(scores.size());
        System.out.println(sc.length);*/
    }
    @Override
    public List<OrderResponseDto> getAllOrder() {
        return null;
    }
    @Override
    public String deleteOrder(int id) {
        return null;
    }

    @Override
    public OrderResponseDto updateOrder(OrderRequestDto data, int id) {
        return null;
    }

    @Override
    public String saveAllOrder(List<OrderRequestDto> items) {
        return null;
    }

    @Override
    public List<Order> deleteAllOrder() {
        return null;
    }
    /* List<Order> orderList;
    public OrderServiceImpl(){
        orderList = new ArrayList<>();//object creation
              Order item1 = new Order(1,"Clipper",32.4,3);//Declaration and creating construction
              Order item2 = new Order(); // creating my second constructor using setters
              item2.setId(2);//set setters for each item
              item2.setName("Comb");
              item2.setPrice(33.7);
              item2.setQuantity(4);
              orderList.add(item1);// this is to add all list of item
              orderList.add(item2);
              orderList.add(Order.builder()//this is a builder and also a constructor. in this everything is done at once.
                      .id(3)
                      .name("Boxers")
                      .price(23.3)
                      .quantity(4)
                      .build());
    }

    @Override
    public List<Order> getAllOrder() {
        return orderList;
    }

    @Override
    public Order getOrder(int id) {
        return orderList.get(id);
    }

    @Override
    public Order saveOrder(Order item) {
        return null;
    }

    @Override
    public String saveAllOrder(List<Order> items) {
        return null;
    }

    @Override
    public Order deleteOrder(int id) {
        return null;
    }

    @Override
    public List<Order> deleteAllOrder() {
        return null;
    }

    @Override
    public Order updateOrder(Order item) {
        return null;
    }*/
}
