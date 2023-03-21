package com.iam.forum.api.controller.dto;

import java.util.List;

public class UserDTO {
    private String name;
    private String username;
    private String password;
    private List<String> role;

    public static UserDTO create(){return new UserDTO();}

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<String> getRole() {
        return role;
    }

    public UserDTO setRole(List<String> role) {
        this.role = role;
        return this;
    }
}
