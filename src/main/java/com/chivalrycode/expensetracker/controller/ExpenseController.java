package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.dto.ExpenseRequestDto;
import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;

import com.chivalrycode.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ExpenseResponseDto> createExpense(@Valid @RequestBody ExpenseRequestDto expenseRequestDto){
        return expenseService.saveExpense(expenseRequestDto);
    }
    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ExpenseResponseDto> getExpenseByCategory(@PathVariable Long id){
        return expenseService.getByCategory(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ExpenseResponseDto> getAllExpense(){
        return expenseService.getAllExpense();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteExpenseById ( @PathVariable Long id){
          return  expenseService.deleteExpense(id);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ExpenseResponseDto> updateExpense (@Valid @RequestBody ExpenseRequestDto expenseDto) {
        return expenseService.updateExpense(expenseDto);
    }
    /*@GetMapping("/generate/report")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ReportResponseDto> generateReport(@RequestParam (required = false) LocalDate startDate,
                                            @RequestParam (required = false)LocalDate endDate,
                                            @RequestParam (required = false)Long category) throws IOException {
        return expenseService.generateReport(startDate, endDate, category);
    }*/
}
