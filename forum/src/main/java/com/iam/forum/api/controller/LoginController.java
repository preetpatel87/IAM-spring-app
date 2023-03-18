package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public User loginValidation(@RequestBody User user) {

        User user =

        return user;
    }
    @GetMapping
    public Admin getAdmin() {
        return Admin.create()
                .setEmail("sample@email.com")
                .setName("Mitul")
                .setId("1");
    }
}
