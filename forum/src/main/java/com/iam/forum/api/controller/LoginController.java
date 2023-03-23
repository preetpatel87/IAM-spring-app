package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.CommentDTO;
import com.iam.forum.api.controller.dto.ThreadDTO;
import com.iam.forum.api.controller.dto.UserDTO;
import com.iam.forum.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO user = loginService.registerUser(userDTO);

        if (isNull(user)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/edit")
    public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO) {
        UserDTO user = loginService.editUser(userDTO);

        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/list")
    public ResponseEntity<List<UserDTO>> getUserList() {
        List<UserDTO> usersDTOListResponse = loginService.getUsersList();
        return ResponseEntity.ok()
                .body(usersDTOListResponse);
    }

}
