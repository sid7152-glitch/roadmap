package com.astrevia.githubLogger.service;

import com.astrevia.githubLogger.model.CommitModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GitHubLogService {
    @Value("${api.url}")
    private String baseUrl;

    public List<CommitModel> getCommits(String devProfile){
        HttpClient client = HttpClient.newHttpClient();
        String baseURL = this.baseUrl.replace("enter_user", devProfile);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/sid7152-glitch/events")).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body());
            return extractCommitRecords(response.body());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static List<CommitModel> extractCommitRecords(String json) {

        // Split each event object
        String[] events = json.split("\\},\\{");
        List<CommitModel> commits = new ArrayList<>();
        System.out.println(events.length);
        for (String event : events) {
            String id = extractValue(event, "\"id\":\"(.*?)\"");
            String type = extractValue(event, "\"type\":\"(.*?)\"");
            String repo = extractValue(event, "\"name\":\"(.*?)\"");
            String head = extractValue(event, "\"head\":\"(.*?)\"");
            String before = extractValue(event, "\"before\":\"(.*?)\"");
            String createdAt = extractValue(event, "\"created_at\":\"(.*?)\"");

            // Only PushEvent contains commit data
            if ("PushEvent".equals(type)) {
                CommitModel commit = new CommitModel(id, repo, head, before, createdAt);
                commits.add(commit);
            }
        }
        return commits;
    }

    public static String extractValue(String text, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "NOT_FOUND";
    }
}
