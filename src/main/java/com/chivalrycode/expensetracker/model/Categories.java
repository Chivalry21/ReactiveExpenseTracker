package com.chivalrycode.expensetracker.model;


import lombok.*;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Categories {
    @Id
    private Long id;
    private String name;

    public Categories(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
