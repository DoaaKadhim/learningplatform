package com.learningplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_learning_activity")
public class UserLearningActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String topic;
    private int score;
    private int timeSpent;
    private LocalDateTime timestamp;

    public UserLearningActivity() {
        this.timestamp = LocalDateTime.now();
    }

    public UserLearningActivity(String userId, String topic, int score, int timeSpent) {
        this.userId = userId;
        this.topic = topic;
        this.score = score;
        this.timeSpent = timeSpent;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}