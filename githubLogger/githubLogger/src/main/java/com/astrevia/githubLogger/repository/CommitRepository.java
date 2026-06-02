package com.astrevia.githubLogger.repository;


import com.astrevia.githubLogger.model.CommitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitRepository extends JpaRepository<CommitModel, Long> {
    //JPARepository<T1, T2>  -> T1 is the Model that represents the table, T2 represents the type of primary key in the model

}
