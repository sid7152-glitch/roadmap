package com.astrevia.githubLogger.repository;

import com.astrevia.githubLogger.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<Repository, Long> {
    Repository findByRepoName(String repoName);
}
