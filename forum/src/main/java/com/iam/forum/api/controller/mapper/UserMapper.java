package com.iam.forum.api.controller.mapper;

import com.iam.forum.api.controller.dto.UserDTO;
import com.iam.forum.model.dao.User;

public class UserMapper {

    public static UserDTO fromDao (User user) {
        return UserDTO.create()
                .setName(user.getName())
                .setPassword(user.getPassword())
                .setUsername(user.getUsername())
                .setRole(user.getRole());
    }

    public static User toDao (UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        return user;
    }
}
