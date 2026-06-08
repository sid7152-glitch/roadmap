package com.astrevia.githubLogger.controller;


import com.astrevia.githubLogger.dto.DevDTO;
import com.astrevia.githubLogger.exception.ErrorResponse;
import com.astrevia.githubLogger.exception.GitHubAPIException;
import com.astrevia.githubLogger.model.CommitModel;
import com.astrevia.githubLogger.service.GitHubLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // -> parent tag
public class GitHubLogController {
    @Autowired
    private GitHubLogService gitHubLogService;

    public GitHubLogController(GitHubLogService gitHubLogService) {
        this.gitHubLogService = gitHubLogService;
    }


    @GetMapping("/health/{name}")
    public String health(@PathVariable("name") String name) {
        return "Established Connection" + name;
    }

    @GetMapping("/github")
    public List<CommitModel> gitLogs(@RequestBody DevDTO dev) {
        String devProfile = dev.getDevProfile();
        return gitHubLogService.getCommits(devProfile);
    }

    @GetMapping("/eventid/{eventId}")
    public String checkEventId(@PathVariable("eventId") String eventId) {
       return gitHubLogService.checkEventId(eventId);
    }

    @GetMapping("/github/db")
    public List<CommitModel> gitLogsfromDB() {
        return gitHubLogService.getCommitsFromDB();
    }

    public ResponseEntity<ErrorResponse> hande(GitHubAPIException ex){}
}
