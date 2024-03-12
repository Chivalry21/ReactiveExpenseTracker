package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto createCategory(CategoryRequestDto requestDto);

    CategoryResponseDto getCategoryById(Long id);

    CategoryResponseDto updateCategory(CategoryRequestDto requestDto);

    void deleteCategory(Long id);
}
