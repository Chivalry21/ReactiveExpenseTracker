package com.chivalrycode.expensetracker.service;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.mapper.CategoryMapper;
import com.chivalrycode.expensetracker.model.Category;
import com.chivalrycode.expensetracker.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    public final CategoryMapper categoryMapper;
    public final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryResponseDto).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toCategory(requestDto);
        Category category1 = categoryRepository.save(category);
        return categoryMapper.toCategoryResponseDto(category1);
        //return categoryMapper.toCategoryResponseDto( categoryRepository.save(categoryMapper.toCategory(requestDto)));
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id){
            Optional<Category>category = categoryRepository.findById(id);
            return category.map(categoryMapper:: toCategoryResponseDto).orElse(null);
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto requestDto) {
        return categoryMapper.toCategoryResponseDto( categoryRepository.save(categoryMapper.toCategory(requestDto)));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
