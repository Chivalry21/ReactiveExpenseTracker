package com.chivalrycode.expensetracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Category extends BaseEntity{
    @Column(nullable = false)
    private String name;

}
