package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.ThreadDTO;
import com.iam.forum.api.controller.dto.UserDTO;
import com.iam.forum.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<UserDTO> loginValidation(@RequestBody UserDTO userDTO) {
        UserDTO user = loginService.validateUser(userDTO);

        if (isNull(user)) {
            return (ResponseEntity<UserDTO>) ResponseEntity.notFound();
        }

        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO user = loginService.registerUser(userDTO);

        if (isNull(user)) {
            return (ResponseEntity<UserDTO>) ResponseEntity.badRequest();
        }

        return ResponseEntity.ok().body(user);
    }

}
