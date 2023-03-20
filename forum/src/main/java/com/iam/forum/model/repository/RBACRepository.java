package com.iam.forum.model.repository;

import com.iam.forum.model.dao.RBAC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RBACRepository extends JpaRepository<RBAC, String> {

}
