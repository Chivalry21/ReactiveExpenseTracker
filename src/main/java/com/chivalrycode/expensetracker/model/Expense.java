package com.chivalrycode.expensetracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Expense extends BaseEntity{
    @Column(nullable = false)
    private String itemName;
    private String description;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private LocalDate date;
    @JoinColumn(name = "category_id",nullable = false)
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Expense{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
