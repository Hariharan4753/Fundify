package com.fundify.fundifylite.service;

import com.fundify.fundifylite.model.Goal;
import com.fundify.fundifylite.model.User;
import com.fundify.fundifylite.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public Goal addGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsByUser(User user) {
        return goalRepository.findByUser(user);
    }

    public Goal updateProgress(Long goalId, Double amount) {
        Goal goal = goalRepository.findById(goalId).orElseThrow();
        goal.setCurrentAmount(amount);
        return goalRepository.save(goal);
    }
}
