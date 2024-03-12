package com.chivalrycode.expensetracker.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CategoryRequestDto {
    private Long id;
    @Size(min = 3, max = 100, message = "Name must be between 3 to 100 characters")
    private String name;

    @Override
    public String toString() {
        return "CategoryRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
