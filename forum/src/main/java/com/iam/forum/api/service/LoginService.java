package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(User user) {
        // Find user in database based on email address
        User foundUser = userRepository.findByEmail(user.getEmail());

        // Check if user exists and if password matches
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser; // Authentication successful
        } else {
            return null; // Authentication failed
        }
    }

    public User registerUser(User user) {
        // Save user to database
        userRepository.save(user);

        // Return the registered User object
        return user;
    }
}
