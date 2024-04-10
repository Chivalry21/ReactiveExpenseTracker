package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Expenses;
import org.springframework.stereotype.Service;

@Service
public class ExpenseMapper {
    public Expenses toExpense(ExpenseRequestDto exp){
        return Expenses.builder()
                .date(exp.getDate())
                .amount(exp.getAmount())
                .description(exp.getDescription())
                .itemName(exp.getItemName())
                .id(exp.getId())
                .categoryId(exp.getCategoryId())
                .build();
    }
    public ExpenseResponseDto toExpenseResponseDto(Expenses expenses){
        return ExpenseResponseDto.builder()
                .amount(expenses.getAmount())
                .itemName(expenses.getItemName())
                .description(expenses.getDescription())
                .date(expenses.getDate())
                .id(expenses.getId())
                .categoryId(expenses.getCategoryId())
                .build();

    }

}
