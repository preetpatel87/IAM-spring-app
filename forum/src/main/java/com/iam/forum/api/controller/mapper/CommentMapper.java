package com.iam.forum.api.controller.mapper;

import com.iam.forum.api.controller.dto.CommentDTO;
import com.iam.forum.model.dao.Comment;

import java.util.List;

public class CommentMapper {

    public static CommentDTO fromDao (Comment comment) {
        return CommentDTO.create()
                .setCommentId(comment.getCommentId())
                .setCommentTitle(comment.getCommentTitle())
                .setCommentContent(comment.getCommentContent())
                .setThreadId(comment.getThreadId())
                .setCreatedBy(comment.getCreatedBy())
                .setDateCreated(comment.getDateCreated());
    }

    public static List<CommentDTO> fromDaolist(List<Comment> commentDao) {
        return commentDao.stream().map(CommentMapper::fromDao).toList();
    }

    public static Comment toDao (CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setCommentId(commentDTO.getCommentId());
        comment.setCommentContent(commentDTO.getCommentContent());
        comment.setCommentTitle(commentDTO.getCommentTitle());
        comment.setCreatedBy(commentDTO.getCreatedBy());
        comment.setDateCreated(commentDTO.getDateCreated());
        comment.setThreadId(commentDTO.getThreadId());

        return comment;
    }
}
