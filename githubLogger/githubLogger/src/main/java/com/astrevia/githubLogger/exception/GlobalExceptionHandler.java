package com.astrevia.githubLogger.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice //Captures the exception in all the controllers and handles it here
public class GlobalExceptionHandler {

    @ExceptionHandler(GitHubAPIException.class) //Captures only the Exception raised as of type GitHubAPIException
    public ResponseEntity<ErrorResponse> handleGithubAPIException(GitHubAPIException ex){ //GitHubAPIException ex -> To retrieve the exception message, ResponseEntity -> To control the response output right now it is of ErrorResponse structure.
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class) //Captures only the Exception raised as of type GitHubAPIException
    public ResponseEntity<ErrorResponse> handleException(Exception ex){ //GitHubAPIException ex -> To retrieve the exception message, ResponseEntity -> To control the response output right now it is of ErrorResponse structure.
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now().toString(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    
}
