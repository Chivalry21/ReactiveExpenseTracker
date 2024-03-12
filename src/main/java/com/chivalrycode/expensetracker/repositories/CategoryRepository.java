package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
