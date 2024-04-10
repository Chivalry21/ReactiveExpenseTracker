package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.model.Expenses;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ExpenseRepository extends ReactiveCrudRepository<Expenses,Long> {
    Flux<Expenses> findByCategoryId(Long id);
}
