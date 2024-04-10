package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.asset.SaveCSV;
import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private  final CategoryService categoryService;
    private final SaveCSV saveCSV;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
      return categoryService.createCategory(categoryRequestDto);
    }
    @GetMapping
    public Flux<CategoryResponseDto> getAllCategories(CategoryRequestDto categoryRequestDto){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Mono<CategoryResponseDto> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<CategoryResponseDto> updateCategory(@RequestBody CategoryRequestDto requestDto){
        return categoryService.updateCategory(requestDto);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }

}
