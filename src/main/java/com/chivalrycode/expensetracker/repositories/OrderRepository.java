package com.chivalrycode.expensetracker.repositories;


import com.chivalrycode.expensetracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}