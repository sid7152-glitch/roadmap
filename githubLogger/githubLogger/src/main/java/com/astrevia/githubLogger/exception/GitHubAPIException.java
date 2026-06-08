package com.astrevia.githubLogger.exception;

public class GitHubAPIException extends RuntimeException{
    public GitHubAPIException(String message){
        super(message);
    }

}
