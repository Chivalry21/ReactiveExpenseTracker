package com.chivalrycode.expensetracker.repositories;

import com.chivalrycode.expensetracker.dto.ExpenseResponseDto;
import com.chivalrycode.expensetracker.model.Category;
import com.chivalrycode.expensetracker.model.Expense;
import com.chivalrycode.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByUser(User user);

    Optional<Expense> findByIdAndUser(Long id, User user);

    List<Expense> findByCategory(Category category);

    List<Expense> findByUserAndCategory(User user, Category category);

    @Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate AND e.category.id = :categoryId AND e.user.id = :userId")
    List<Expense> findByDateRangeAndCategory(@Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate,
                                             @Param("categoryId") Long categoryId,
                                             @Param("userId") Long userId);

    @Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate AND e.user.id = :userId")
    List<Expense> findByDateRange(@Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate,
                                             @Param("userId") Long userId);



}
