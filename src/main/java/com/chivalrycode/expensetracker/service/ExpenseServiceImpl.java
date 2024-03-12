package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.exception.CategoryNotFoundException;
import com.chivalrycode.expensetracker.mapper.ExpenseMapper;
import com.chivalrycode.expensetracker.model.Category;
import com.chivalrycode.expensetracker.model.Expense;
import com.chivalrycode.expensetracker.model.User;
import com.chivalrycode.expensetracker.repositories.CategoryRepository;
import com.chivalrycode.expensetracker.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseMapper expenseMapper;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ExpenseResponseDto> getAllExpense() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        List<Expense> expenses = expenseRepository.findAllByUser(user);
        return expenses.stream().map(expenseMapper::toExpenseResponseDto).collect(Collectors.toList());
    }
    @Override
    public ExpenseResponseDto getExpenseById(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Optional<Expense>expense = expenseRepository.findByIdAndUser(id, user);
        return expense.map(expenseMapper::toExpenseResponseDto).orElse(null);
    }
    @Override
    public ExpenseResponseDto saveExpense(ExpenseRequestDto exp) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Expense expense = expenseMapper.toExpense(exp);
        Optional<Category>category = categoryRepository.findById(exp.getCategoryId());
        expense.setCategory(category.get());
        expense.setUser(user);
        Expense expense1 = expenseRepository.save(expense);
        return expenseMapper.toExpenseResponseDto(expense1);
    }
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.findById(id) ;
    }
    @Override
    public ExpenseResponseDto updateExpense(ExpenseRequestDto expense) {
        return expenseMapper.toExpenseResponseDto(expenseRepository.save(expenseMapper.toExpense(expense)));
    }

    @Override
    public List<ExpenseResponseDto> getByCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty())
            throw new CategoryNotFoundException("Category not found");
        return expenseRepository.findByCategory(category.get()).stream().map(expenseMapper::toExpenseResponseDto).collect(Collectors.toList());

    }
}
