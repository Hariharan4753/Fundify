package com.fundify.fundifylite.controller;

import com.fundify.fundifylite.model.Goal;
import com.fundify.fundifylite.model.User;
import com.fundify.fundifylite.service.GoalService;
import com.fundify.fundifylite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private UserService userService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Goal> addGoal(@PathVariable Long userId, @RequestBody Goal goal) {
        Optional<User> user = userService.findById(userId);
        if(user.isPresent()) {
            goal.setUser(user.get());
            return ResponseEntity.ok(goalService.addGoal(goal));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Goal>> getUserGoals(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if(user.isPresent()) {
            return ResponseEntity.ok(goalService.getGoalsByUser(user.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{goalId}")
    public ResponseEntity<Goal> updateGoalProgress(@PathVariable Long goalId, @RequestParam Double amount) {
        return ResponseEntity.ok(goalService.updateProgress(goalId, amount));
    }
}
