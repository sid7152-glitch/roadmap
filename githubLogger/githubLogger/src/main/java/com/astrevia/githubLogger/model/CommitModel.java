package com.astrevia.githubLogger.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="commit_records")
@NoArgsConstructor
@Getter
@Setter
//@AllArgsConstructor

public class CommitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "event_id")
    private String eventID = "";
//    @Column(name = "")
//    private String repository = "";
    @Column(name = "commit_head")
    private String commitHead = "";
    @Column(name = "before_hand")
    private String beforeHand = "";
    @Column(name = "created_at")
    private String createdAt = "";

   public CommitModel(String eventID, String commitHead, String beforeHand, String createdAt) {
        this.eventID = eventID;
//        this.repository = repository;
        this.commitHead = commitHead;
        this.beforeHand = beforeHand;
        this.createdAt = createdAt;
    }

    @ManyToOne //I say many of the commits sit here belongs to some particular users, but I'm sure that one commit belongs to one user.
    @JoinColumn(name = "user_id") // To mention the foriegn key(in Java the variable name) in the table so it can confirm that this particular commit belongs to that user
    private CommitUser commitUser;

   @ManyToOne
   @JoinColumn(name = "repo_id")
   private Repository commitRepo;
    /*

//    Getter and Setter annotation is already in use
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
    */
    //Already @toString annotation used in the class level
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Commit{");
//        sb.append("eventID=").append(eventID);
//        sb.append(", repository=").append(repository);
//        sb.append(", commitHead=").append(commitHead);
//        sb.append(", beforeHand=").append(beforeHand);
//        sb.append(", createdAt=").append(createdAt);
//        sb.append('}');
//        return sb.toString();
//    }

}
