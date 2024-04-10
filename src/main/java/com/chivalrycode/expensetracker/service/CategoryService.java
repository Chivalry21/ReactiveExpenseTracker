package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface CategoryService {
    Flux<CategoryResponseDto> getAllCategories();

    Mono<CategoryResponseDto> createCategory(CategoryRequestDto requestDto);

    Mono<CategoryResponseDto> getCategoryById(Long id);

    Mono<CategoryResponseDto> updateCategory(CategoryRequestDto requestDto);

    Mono<Void> deleteCategory(Long id);
}
