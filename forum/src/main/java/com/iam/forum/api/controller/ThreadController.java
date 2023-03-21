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
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .body(threadDTOResponseBody);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<List<ThreadDTO>> getThreadList() {
        List<ThreadDTO> threadDTOListResponseBody = threadService.getThreadList();
        return ResponseEntity.ok()
                .body(threadDTOListResponseBody);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity createThread(@RequestBody ThreadDTO createThreadRequestDTO) {
        Boolean createThreadResponse = threadService.createThread(createThreadRequestDTO);

        if (!createThreadResponse) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/edit")
    public ResponseEntity editThread(@RequestBody ThreadDTO editThreadRequestDTO) {
        Boolean editThreadResponse = threadService.editThread(editThreadRequestDTO);

        if (!editThreadResponse) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{threadId}")
    public ResponseEntity deleteThread(@PathVariable Integer threadId) {
        Boolean deleteThreadResponse = threadService.deleteThread(threadId);

        if (!deleteThreadResponse) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
