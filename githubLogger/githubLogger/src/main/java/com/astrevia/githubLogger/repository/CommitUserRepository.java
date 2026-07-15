package com.astrevia.githubLogger.repository;

import com.astrevia.githubLogger.model.CommitUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitUserRepository extends JpaRepository<CommitUser, Long> {
    CommitUser findByUserName(String userName);
}
