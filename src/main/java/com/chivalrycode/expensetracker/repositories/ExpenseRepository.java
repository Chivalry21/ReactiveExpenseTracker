package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Category;
import com.chivalrycode.expensetracker.model.Expense;
import com.chivalrycode.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByUser(User user);

    Optional<Expense> findByIdAndUser(Long id, User user);

    List<Expense> findByCategory(Category category);
}
