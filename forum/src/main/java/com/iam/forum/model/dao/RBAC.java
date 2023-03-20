package com.iam.forum.model.dao;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "RBAC")
@EntityListeners(AuditingEntityListener.class)
public class RBAC {
    @Id
    @Column(name = "role", nullable = false)
    private String role;
    @Type(ListArrayType.class)
    @Column(name = "permissions", columnDefinition = "text[]", nullable = false)
    private List<String> APIPermissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAPIPermissions() {
        return APIPermissions;
    }

    public void setAPIPermissions(List<String> APIPermissions) {
        this.APIPermissions = APIPermissions;
    }
}
