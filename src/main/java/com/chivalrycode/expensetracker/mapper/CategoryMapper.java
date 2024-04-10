package com.chivalrycode.expensetracker.mapper;

import com.chivalrycode.expensetracker.dto.CategoryRequestDto;
import com.chivalrycode.expensetracker.dto.CategoryResponseDto;
import com.chivalrycode.expensetracker.model.Categories;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Categories toCategory(CategoryRequestDto categoryRequestDto){
        Categories categories = new Categories(categoryRequestDto.getName());
        categories.setId(categoryRequestDto.getId());
        return categories;
}
    public CategoryResponseDto toCategoryResponseDto(Categories categories){
        return CategoryResponseDto.builder()
                .name(categories.getName())
                .id(categories.getId())
                .build();
    }

}
