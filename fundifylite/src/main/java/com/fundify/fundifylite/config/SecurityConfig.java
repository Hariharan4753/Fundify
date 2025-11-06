package com.fundify.fundifylite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Optional: Password encoder for hashing (keep for future use)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Disable security temporarily so Postman requests don't get 401
   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // disable CSRF for POST/PUT testing
            .authorizeHttpRequests()
            .anyRequest().permitAll(); // allow all requests without authentication
        return http.build();
    }*/
}
