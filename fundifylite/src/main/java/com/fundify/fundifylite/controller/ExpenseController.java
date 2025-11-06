package com.fundify.fundifylite.controller;

import com.fundify.fundifylite.model.Expense;
import com.fundify.fundifylite.model.User;
import com.fundify.fundifylite.service.ExpenseService;
import com.fundify.fundifylite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    // Add an expense for a specific user
    @PostMapping("/add/{userId}")
    public ResponseEntity<Expense> addExpense(@PathVariable Long userId, @RequestBody Expense expense) {
        Optional<User> user = userService.findById(userId);  // ✅ Use findById
        if(user.isPresent()) {
            expense.setUser(user.get());
            return ResponseEntity.ok(expenseService.addExpense(expense));
        }
        return ResponseEntity.badRequest().build();
    }

    // Get all expenses of a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);  // ✅ Use findById
        if(user.isPresent()) {
            return ResponseEntity.ok(expenseService.getExpensesByUser(user.get()));
        }
        return ResponseEntity.badRequest().build();
    }
}
