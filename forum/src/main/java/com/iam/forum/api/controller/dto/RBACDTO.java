package com.iam.forum.api.controller.dto;

import java.util.List;

public class RBACDTO {
    private String role;
    private List<String> APIPermissions;

    public static RBACDTO create(){return new RBACDTO();}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAPIPermissions() {
        return APIPermissions;
    }

    public void setAPIPermissions(List<String> APIPermissions) {
        this.APIPermissions = APIPermissions;
    }
}
