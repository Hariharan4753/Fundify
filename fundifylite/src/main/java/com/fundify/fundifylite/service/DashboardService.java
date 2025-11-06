package com.fundify.fundifylite.service;

import com.fundify.fundifylite.model.Expense;
import com.fundify.fundifylite.model.Goal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    public Double calculateTotalExpenses(List<Expense> expenses) {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public Double calculateGoalProgress(Goal goal) {
        return (goal.getCurrentAmount() / goal.getTargetAmount()) * 100;
    }
}
