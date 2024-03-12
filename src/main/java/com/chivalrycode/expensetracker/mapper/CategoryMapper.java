package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Category toCategory(CategoryRequestDto categoryRequestDto){
        Category category = new Category(categoryRequestDto.getName());
        category.setId(categoryRequestDto.getId());
        return category;
}
    public CategoryResponseDto toCategoryResponseDto(Category category){
        return CategoryResponseDto.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }

}
