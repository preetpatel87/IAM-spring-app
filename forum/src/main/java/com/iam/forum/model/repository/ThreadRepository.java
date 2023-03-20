package com.iam.forum.model.repository;

import com.iam.forum.model.dao.Thread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<Thread, Integer> {

}
