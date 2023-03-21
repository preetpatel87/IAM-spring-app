package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.ThreadDTO;
import com.iam.forum.api.controller.mapper.ThreadMapper;
import com.iam.forum.model.dao.Thread;
import com.iam.forum.model.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    public ThreadDTO getThread(Integer threadId){
        try {
            Thread threadResponse = threadRepository.findById(threadId).orElseThrow();
            return ThreadMapper.fromDao(threadResponse);
        }
        catch (Exception ex){
            return null;
        }
    }

    public List<ThreadDTO> getThreadList() {
        try {
            List<Thread> threadListResponse = threadRepository.findAll();
            return ThreadMapper.fromDaolist(threadListResponse);
        }
        catch (Exception ex){
            return null;
        }
    }


    public Boolean createThread(ThreadDTO createThreadRequestDTO) {
        try {
            Thread thread = ThreadMapper.toDao(createThreadRequestDTO);
            threadRepository.save(thread);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public Boolean editThread(ThreadDTO editThreadRequestDTO) {
        try {
            Optional<Thread> thread = threadRepository.findById(editThreadRequestDTO.getThreadId());

            if (thread.isPresent()){
                Thread editThreadEntity = ThreadMapper.toDao(editThreadRequestDTO);
                threadRepository.save(editThreadEntity);
                return true;
            }

            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public Boolean deleteThread(Integer threadId) {
        try {
            threadRepository.deleteById(threadId);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
