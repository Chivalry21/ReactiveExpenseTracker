package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Expense;

import com.chivalrycode.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> createExpense(@Valid @RequestBody ExpenseRequestDto expenseRequestDto){
        ExpenseResponseDto createdExpense = expenseService.saveExpense(expenseRequestDto);
        return  new ResponseEntity<>(createdExpense,HttpStatus.CREATED);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ExpenseResponseDto>> getExpenseByCategory(@PathVariable Long id){
        List<ExpenseResponseDto> expenses = expenseService.getByCategory(id);
        return ResponseEntity.ok(expenses);
    }
    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpense(){
        List<ExpenseResponseDto> expenses = expenseService.getAllExpense();
        return ResponseEntity.ok(expenses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        ExpenseResponseDto expenseResponseDto = expenseService.getExpenseById(id);
            return new ResponseEntity<>(expenseResponseDto, HttpStatus.OK);
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById ( @PathVariable Long id){
            expenseService.deleteExpense(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
    @PutMapping
    public ResponseEntity<ExpenseResponseDto> updateExpense (@RequestBody ExpenseRequestDto expenseDto){
        ExpenseResponseDto updatedExpense = expenseService.updateExpense(expenseDto);
            return new ResponseEntity<>(updatedExpense, HttpStatus.OK);//service.updateExpense(expense,id);
        }
        @GetMapping("/generate/report")
    public String generateReport(@RequestParam (required = false) LocalDate startDate,
                                 @RequestParam (required = false)LocalDate endDate,
                                 @RequestParam (required = false)String category){

            System.out.println(startDate);
            System.out.println(endDate);
            System.out.println(category);
        return null;
    }
}
