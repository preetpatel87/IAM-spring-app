package com.iam.forum.model.repository;

import com.iam.forum.model.dao.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
