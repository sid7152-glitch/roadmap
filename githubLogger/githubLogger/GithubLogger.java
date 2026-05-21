package GitHubLogger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GithubLogger {

    public static List<Commit> extractCommitRecords(String json) {

        // Split each event object
        String[] events = json.split("\\},\\{");
        List<Commit> commits = new ArrayList<>();
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
                /*
                System.out.println("================================");
                System.out.println("Event ID    : " + id);
                System.out.println("Repository  : " + repo);
                System.out.println("Commit Head : " + head);
                System.out.println("Before Hash : " + before);
                System.out.println("Created At  : " + createdAt);
                 */
                Commit commit = new Commit(id, repo, head, before, createdAt);
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

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/sid7152-glitch/events")).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body());
            System.out.println(extractCommitRecords(response.body()));
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
