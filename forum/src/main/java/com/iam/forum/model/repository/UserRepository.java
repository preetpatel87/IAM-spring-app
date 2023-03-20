package com.iam.forum.model.repository;

import com.iam.forum.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
