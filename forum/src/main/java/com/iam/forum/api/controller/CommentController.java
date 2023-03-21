package com.iam.forum.api.controller;

import com.iam.forum.api.controller.dto.CommentDTO;
import com.iam.forum.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<List<CommentDTO>> getCommentsList() {
        List<CommentDTO> commentDTOListResponseBody = commentService.getCommentList();
        return ResponseEntity.ok()
                .body(commentDTOListResponseBody);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity createComment(@RequestBody CommentDTO createCommentRequestDTO) {
        Boolean createCommentResponse = commentService.createComment(createCommentRequestDTO);

        if (!createCommentResponse) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/edit")
    public ResponseEntity editComment(@RequestBody CommentDTO editCommentRequestDTO) {
        Boolean editCommentResponse = commentService.editComment(editCommentRequestDTO);

        if (!editCommentResponse) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Integer commentId) {
        Boolean deleteCommentResponse = commentService.deleteComment(commentId);

        if (!deleteCommentResponse) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
