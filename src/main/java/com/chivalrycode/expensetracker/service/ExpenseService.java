package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Category;
import com.chivalrycode.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<ExpenseResponseDto> getAllExpense();
    ExpenseResponseDto getExpenseById(Long id);
    ExpenseResponseDto saveExpense(ExpenseRequestDto expense);
    void deleteExpense(Long id);
    ExpenseResponseDto updateExpense(ExpenseRequestDto expense);
    List<ExpenseResponseDto> getByCategory(Long id);



}
