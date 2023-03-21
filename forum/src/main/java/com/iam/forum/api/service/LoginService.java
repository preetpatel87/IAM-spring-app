package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(User user) {
        // validate user credentials here and return true if valid, false otherwise
        // in this example, always return true for demo purposes
        return true;
    }
}
