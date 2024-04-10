package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.asset.SaveCSV;
import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.mapper.ExpenseMapper;
import com.chivalrycode.expensetracker.model.Expenses;
import com.chivalrycode.expensetracker.repositories.CategoryRepository;
import com.chivalrycode.expensetracker.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseMapper expenseMapper;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final SaveCSV saveCSV;

    @Override
    public Flux<ExpenseResponseDto> getAllExpense() {
        return  (expenseRepository.findAll().map(expenseMapper::toExpenseResponseDto));
    }
    @Override
    public Mono<ExpenseResponseDto> getExpenseById(Long id) {
        return (expenseRepository.findById(id)).map(expenseMapper::toExpenseResponseDto);
    }
    @Override
    public Mono<ExpenseResponseDto> saveExpense(ExpenseRequestDto exp) {
        Expenses expenses = expenseMapper.toExpense(exp);
        expenses.setCategoryId(exp.getCategoryId());
        return (expenseRepository.save(expenses)).map(expenseMapper::toExpenseResponseDto);
    }
    @Override
    public Mono<Void> deleteExpense(Long id) {
        return expenseRepository.findById(id).then();
    }
    @Override
    public Mono<ExpenseResponseDto> updateExpense(ExpenseRequestDto expense) {
        return expenseRepository.save(expenseMapper.toExpense(expense)).map(expenseMapper::toExpenseResponseDto);
    }

    @Override
    public Flux<ExpenseResponseDto> getByCategory(Long id) {
        return expenseRepository.findByCategoryId(id).map(expenseMapper::toExpenseResponseDto);
    }


}
