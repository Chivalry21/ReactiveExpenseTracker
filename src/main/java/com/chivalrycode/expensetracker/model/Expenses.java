package com.chivalrycode.expensetracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Expenses {
    @Id
    private Long id;
    private String itemName;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Long categoryId;


    @Override
    public String toString() {
        return "Expense{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
