package com.fundify.fundifylite.repository;

import com.fundify.fundifylite.model.Expense;
import com.fundify.fundifylite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
