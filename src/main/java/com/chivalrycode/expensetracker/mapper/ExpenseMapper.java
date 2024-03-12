package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Expense;
import org.springframework.stereotype.Service;

@Service
public class ExpenseMapper {
    public Expense toExpense(ExpenseRequestDto exp){
        return Expense.builder()
                .date(exp.getDate())
                .amount(exp.getAmount())
                .description(exp.getDescription())
                .itemName(exp.getItemName())
                .build();
    }
    public ExpenseResponseDto toExpenseResponseDto(Expense expense){
        return ExpenseResponseDto.builder()
                .amount(expense.getAmount())
                .itemName(expense.getItemName())
                .description(expense.getDescription())
                .date(expense.getDate())
                .id(expense.getId())
                .category(expense.getCategory())
                .build();

    }

}
