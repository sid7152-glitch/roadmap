package com.astrevia.githubLogger.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commit_user")
@Getter
@Setter
@NoArgsConstructor
public class CommitUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "avatar_url")
    private String avatar_url;

    public CommitUser(String userName, String avatar_url) {
        this.userName = userName;
        this.avatar_url = avatar_url;
    }

    @OneToMany(mappedBy = "commitUser")
    List<CommitModel> commits = new ArrayList<>();

    //Many to many can be defined as a husband and wife relationship, the middle table which hold the foreign key of both the class acts as a bridge between both. The husband hold the
    //major responsibility, so he has to define the relationship("@JoinTable"), where as the wife can just point the husband if something happens("mappedBy")
    @ManyToMany
    @JoinTable(
            name = "user_repository", //name of the table which holds the foreign key of both the table
            joinColumns = @JoinColumn(name = "user_id"), // foreign key of the existing class
            inverseJoinColumns = @JoinColumn(name = "repo_id") // foreign key of the relationship class
    )
    List<Repository> repositories = new ArrayList<>();

}

