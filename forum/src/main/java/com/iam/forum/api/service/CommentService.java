package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.CommentDTO;
import com.iam.forum.api.controller.mapper.CommentMapper;
import com.iam.forum.model.dao.Comment;
import com.iam.forum.model.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getCommentList() {
        try {
            List<Comment> commentListResponse = commentRepository.findAll();
            return CommentMapper.fromDaolist(commentListResponse);
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean createComment(CommentDTO createCommentRequestDTO) {
        try {
            createCommentRequestDTO.setDateCreated(new Date());
            Comment comment = CommentMapper.toDao(createCommentRequestDTO);
            commentRepository.save(comment);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean editComment(CommentDTO editCommentRequestDTO) {
        try {
            Optional<Comment> comment = commentRepository.findById(editCommentRequestDTO.getCommentId());

            if (comment.isPresent()) {
                editCommentRequestDTO.setDateCreated(comment.get().getDateCreated());
                Comment editCommentEntity = CommentMapper.toDao(editCommentRequestDTO);
                commentRepository.save(editCommentEntity);
                return true;
            }

            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean deleteComment(Integer commentId) {
        try {
            commentRepository.deleteById(commentId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
