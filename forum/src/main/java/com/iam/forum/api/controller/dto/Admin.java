package com.iam.forum.api.controller.dto;

public class Admin {
    private String id;
    private String name;
    private String email;
    public static Admin create() { return new Admin(); }

    public String getId() {
        return id;
    }

    public Admin setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Admin setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
