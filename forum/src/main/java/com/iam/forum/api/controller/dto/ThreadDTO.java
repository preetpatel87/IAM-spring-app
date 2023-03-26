package com.iam.forum.api.controller.dto;

import java.util.Date;

public class ThreadDTO {
    private Integer threadId;
    private String threadName;
    private String threadDescription;
    private String createdBy;
    private Date dateCreated;

    public static ThreadDTO create(){return new ThreadDTO();}

    public Integer getThreadId() {
        return threadId;
    }

    public ThreadDTO setThreadId(Integer threadId) {
        this.threadId = threadId;
        return this;
    }

    public String getThreadName() {
        return threadName;
    }

    public ThreadDTO setThreadName(String threadName) {
        this.threadName = threadName;
        return this;
    }

    public String getThreadDescription() {
        return threadDescription;
    }

    public ThreadDTO setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ThreadDTO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ThreadDTO setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
