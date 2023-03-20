package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.User;
import com.iam.forum.api.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<User> loginValidation(@RequestBody User user) {
        return ResponseEntity.ok().body(new User());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity registerUser(@RequestBody User user) {

        return (ResponseEntity) ResponseEntity.ok();
    }

}
