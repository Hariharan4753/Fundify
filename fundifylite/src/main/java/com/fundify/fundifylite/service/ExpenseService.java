package com.fundify.fundifylite.service;

import com.fundify.fundifylite.model.Expense;
import com.fundify.fundifylite.model.User;
import com.fundify.fundifylite.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }
}
