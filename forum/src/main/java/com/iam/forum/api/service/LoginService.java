package com.iam.forum.api.service;

import com.iam.forum.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {

    @Autowired
    private UserRepository userRepository;

}
