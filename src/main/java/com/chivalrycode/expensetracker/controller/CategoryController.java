package com.chivalrycode.expensetracker.controller;

import com.chivalrycode.expensetracker.asset.SaveCSV;
import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private  final CategoryService categoryService;
    private final SaveCSV saveCSV;
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto createdCategory = categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(CategoryRequestDto categoryRequestDto){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
       //return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CategoryResponseDto updateCategory(@RequestBody CategoryRequestDto requestDto){
        return categoryService.updateCategory(requestDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/test")
    public String doSomething() throws IOException {
       return  saveCSV.createCSVFile("./src/main/resources/Sample.csv","Sample content");
    }
}
