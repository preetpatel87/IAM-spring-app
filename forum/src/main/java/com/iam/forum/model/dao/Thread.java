package com.iam.forum.model.dao;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "Threads")
@EntityListeners(AuditingEntityListener.class)
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer threadId;
    @Column(name = "thread_name", nullable = false)
    private String threadName;
    @Column(name = "thread_description", nullable = false)
    private String threadDescription;
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadDescription() {
        return threadDescription;
    }

    public void setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
