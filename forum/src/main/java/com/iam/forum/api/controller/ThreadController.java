package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.Thread;
import com.iam.forum.api.service.ThreadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thread")
public class ThreadController {

    @GetMapping
    public ResponseEntity<Thread> getThread() {

        /*
        In controller, first define the mapping path and method
        Then call a service method to get the data that will be included in the response
        Then create and return a ResponseEntity
         */

        Thread threadResponseBody = ThreadService.getThread();

        return ResponseEntity.ok()
                .body(threadResponseBody);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity createAdminRequest(@RequestBody Thread createAdminRequest) {
        return (ResponseEntity) ResponseEntity.ok();
    }
}
