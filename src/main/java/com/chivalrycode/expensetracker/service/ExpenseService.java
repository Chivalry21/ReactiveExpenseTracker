package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExpenseService {
    Flux<ExpenseResponseDto> getAllExpense();
    Mono<ExpenseResponseDto> getExpenseById(Long id);
    Mono<ExpenseResponseDto> saveExpense(ExpenseRequestDto expense);
    Mono<Void> deleteExpense(Long id);
    Mono<ExpenseResponseDto> updateExpense(ExpenseRequestDto expense);
    Flux<ExpenseResponseDto> getByCategory(Long id);




}
