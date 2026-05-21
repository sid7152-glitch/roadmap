package GitHubLogger;

public class Commit {

    private String eventID = "";
    private String repository = "";
    private String commitHead = "";
    private String beforeHand = "";
    private String createdAt = "";

    public Commit(String eventID, String repository, String commitHead, String beforeHand, String createdAt) {
        this.eventID = eventID;
        this.repository = repository;
        this.commitHead = commitHead;
        this.beforeHand = beforeHand;
        this.createdAt = createdAt;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getCommitHead() {
        return commitHead;
    }

    public void setCommitHead(String commitHead) {
        this.commitHead = commitHead;
    }

    public String getBeforeHand() {
        return beforeHand;
    }

    public void setBeforeHand(String beforeHand) {
        this.beforeHand = beforeHand;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commit{");
        sb.append("eventID=").append(eventID);
        sb.append(", repository=").append(repository);
        sb.append(", commitHead=").append(commitHead);
        sb.append(", beforeHand=").append(beforeHand);
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }

}
