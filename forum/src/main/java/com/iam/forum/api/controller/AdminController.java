package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.Admin;
import com.iam.forum.api.controller.dto.CreateAdminRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.POST, path = "/createThread")
    public Admin createAdminRequest(@RequestBody CreateAdminRequest createAdminRequest) {
        return Admin.create()
                .setEmail("sample@email.com")
                .setName("Mitul")
                .setId("1");
    }
    @GetMapping
    public Admin getAdmin() {
        return Admin.create()
                .setEmail("sample@email.com")
                .setName("Mitul")
                .setId("1");
    }
}