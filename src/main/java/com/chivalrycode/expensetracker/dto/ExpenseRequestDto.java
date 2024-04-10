package com.chivalrycode.expensetracker.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ExpenseRequestDto {

    private Long id;
    @NotBlank
    private String itemName;
    private String description;
    @DecimalMin(value = "500")
    private BigDecimal amount;
    @PastOrPresent
    @NotNull
    private LocalDate date;
    @NotBlank
    private Long categoryId;


    @Override
    public String toString() {
        return "ExpenseRequestDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", categoryId=" + categoryId +
                '}';
    }
}

