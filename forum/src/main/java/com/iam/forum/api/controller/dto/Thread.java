package com.iam.forum.api.controller.dto;

import java.util.Date;

public class Thread {
    private Integer threadId;
    private String threadName;
    private String threadDescription;
    private Date dateCreated;

    public static Thread create(){return new Thread();}

    public Integer getThreadId() {
        return threadId;
    }

    public Thread setThreadId(Integer threadId) {
        this.threadId = threadId;
        return this;
    }

    public String getThreadName() {
        return threadName;
    }

    public Thread setThreadName(String threadName) {
        this.threadName = threadName;
        return this;
    }

    public String getThreadDescription() {
        return threadDescription;
    }

    public Thread setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Thread setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
