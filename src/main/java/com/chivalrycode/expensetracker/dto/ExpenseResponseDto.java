package com.chivalrycode.expensetracker.dto;

import com.chivalrycode.expensetracker.model.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ExpenseResponseDto {
    private Long id;
    private String itemName;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;

}
