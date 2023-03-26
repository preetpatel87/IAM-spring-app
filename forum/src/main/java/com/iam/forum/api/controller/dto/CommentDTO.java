package com.iam.forum.api.controller.dto;

import java.util.Date;

public class CommentDTO {
    private Integer commentId;
    private Integer threadId;
    private String commentTitle;
    private String commentContent;
    private String createdBy;
    private Date dateCreated;

    public static CommentDTO create(){return new CommentDTO();}

    public Integer getCommentId() {
        return commentId;
    }

    public CommentDTO setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public CommentDTO setThreadId(Integer threadId) {
        this.threadId = threadId;
        return this;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public CommentDTO setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
        return this;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public CommentDTO setCommentContent(String commentContent) {
        this.commentContent = commentContent;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public CommentDTO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public CommentDTO setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
