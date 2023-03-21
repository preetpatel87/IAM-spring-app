package com.iam.forum.api.controller.mapper;

import com.iam.forum.api.controller.dto.ThreadDTO;
import com.iam.forum.model.dao.Thread;

import java.util.List;

public class ThreadMapper {
    public static ThreadDTO fromDao (Thread thread) {
        return ThreadDTO.create()
                .setThreadId(thread.getThreadId())
                .setThreadName(thread.getThreadName())
                .setThreadDescription(thread.getThreadDescription())
                .setDateCreated(thread.getDateCreated());
    }
    public static List<ThreadDTO> fromDaolist(List<Thread> threadDao) {
        return threadDao.stream().map(ThreadMapper::fromDao).toList();
    }

    public static Thread toDao (ThreadDTO threadDTO) {
        Thread thread = new Thread();
        thread.setThreadId(threadDTO.getThreadId());
        thread.setThreadName(threadDTO.getThreadName());
        thread.setThreadDescription(threadDTO.getThreadDescription());
        thread.setDateCreated(threadDTO.getDateCreated());
        return thread;
    }
}
