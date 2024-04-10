package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.model.Categories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Categories,Long> {
}
