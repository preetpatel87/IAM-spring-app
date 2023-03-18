package com.iam.forum.api.controller.dto;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> role;

    public static User create(){return new User();}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
