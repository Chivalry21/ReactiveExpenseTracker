package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.mapper.CategoryMapper;
import com.chivalrycode.expensetracker.model.Categories;
import com.chivalrycode.expensetracker.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    public final CategoryMapper categoryMapper;
    public final CategoryRepository categoryRepository;

    @Override
    public Flux<CategoryResponseDto> getAllCategories() {
        return (categoryRepository.findAll()).map(categoryMapper::toCategoryResponseDto);
    }

    @Override
    public Mono<CategoryResponseDto> createCategory(CategoryRequestDto requestDto) {
        Categories categories = categoryMapper.toCategory(requestDto);
        return categoryRepository.save(categories).map(categoryMapper::toCategoryResponseDto);
    }
    @Override
    public Mono<CategoryResponseDto> getCategoryById(Long id){
            return (categoryRepository.findById(id)).map(categoryMapper::toCategoryResponseDto);
    }

    @Override
    public Mono<CategoryResponseDto> updateCategory(CategoryRequestDto requestDto) {
        return (categoryRepository.save(categoryMapper.toCategory(requestDto))).map(categoryMapper::toCategoryResponseDto);
    }

    @Override
    public Mono<Void> deleteCategory(Long id) {
        return categoryRepository.deleteById(id);
    }
}
