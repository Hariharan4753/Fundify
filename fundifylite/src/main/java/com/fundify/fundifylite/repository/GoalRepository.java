package com.fundify.fundifylite.repository;

import com.fundify.fundifylite.model.Goal;
import com.fundify.fundifylite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser(User user);
}
