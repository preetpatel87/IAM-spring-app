package com.iam.forum.api.service;

import com.iam.forum.api.controller.dto.Thread;
import com.iam.forum.model.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    public static Thread getThread(){

        /*
        Get thread from query
        Here the Thread is the DAO
        Thread thread = queryDatabase();


        Then create the DTO Thread
        Thread.create()
                .setThreadId(thread.Id)
                .setThreadName(thread.Name)
                .setThreadDescription(thread.description)
                .setDateCreated(thread.dateCreated)


         Also create exception handler by adding a try and catch block, for the catch block return a response entity
         with an error code
         Eg,
            return ResponseEntity.notFound();
         */

        return Thread.create()
                .setThreadId(1)
                .setThreadName("name")
                .setThreadDescription("description")
                .setDateCreated(new Date());

    }
}
