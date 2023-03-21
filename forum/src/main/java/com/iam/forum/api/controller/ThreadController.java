package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.ThreadDTO;
import com.iam.forum.api.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/thread")
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @RequestMapping(method = RequestMethod.GET, path = "/{threadId}")
    public ResponseEntity<ThreadDTO> getThread(@PathVariable Integer threadId) {
        ThreadDTO threadDTOResponseBody = threadService.getThread(threadId);

        if (isNull(threadDTOResponseBody)) {
            return (ResponseEntity<ThreadDTO>) ResponseEntity.notFound();
        }

        return ResponseEntity.ok()
                .body(threadDTOResponseBody);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity createThread(@RequestBody ThreadDTO createThreadRequestDTO) {
        Boolean createThreadResponse = threadService.createThread(createThreadRequestDTO);

        if (createThreadResponse) {
            return (ResponseEntity) ResponseEntity.badRequest();
        }

        return (ResponseEntity) ResponseEntity.ok();
    }
}
