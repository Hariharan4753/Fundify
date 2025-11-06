package com.fundify.fundifylite.service;

import com.fundify.fundifylite.model.User;
import com.fundify.fundifylite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register user with hashed password
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password
        return userRepository.save(user);
    }

    // Verify password for login
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email); // just return it directly
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
