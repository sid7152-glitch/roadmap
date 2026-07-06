package com.astrevia.githubLogger.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "repository")
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "repo_name")
    private String repoName;

    public Repository(String repoName) {
        this.repoName = repoName;
    }

    //We can say "mappedby" as managed by the variable of that class it stays, meaning the class manages the connection or leads the connection
    @OneToMany(mappedBy = "commitRepo")
    List<CommitModel> repoCommit = new ArrayList<>();
    @ManyToMany(mappedBy = "repositories")
    List<CommitUser> users = new ArrayList<>();
}
