package com.learningplatform.service;

import com.learningplatform.model.UserLearningActivity;
import com.learningplatform.repository.UserLearningActivityRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LearningService {

    private final UserLearningActivityRepository repository;

    public LearningService(UserLearningActivityRepository repository) {
        this.repository = repository;
    }

    // Save activity
    public UserLearningActivity saveActivity(UserLearningActivity activity) {
        return repository.save(activity);
    }

    // Analytics
    public Map<String, Object> getAnalytics(String userId) {

        List<UserLearningActivity> activities = repository.findByUserId(userId);

        double avgScore = activities.stream()
                .mapToInt(UserLearningActivity::getScore)
                .average()
                .orElse(0);

        int totalTime = activities.stream()
                .mapToInt(UserLearningActivity::getTimeSpent)
                .sum();

        Map<String, Object> result = new HashMap<>();
        result.put("avgScore", avgScore);
        result.put("totalTime", totalTime);
        result.put("totalActivities", activities.size());

        return result;
    }

    // 🧠 AI Adaptive Recommendation System (FIXED)
    public Map<String, Object> getRecommendation(String userId) {

        List<UserLearningActivity> activities = repository.findByUserId(userId);

        Map<String, Object> result = new HashMap<>();

        if (activities.isEmpty()) {
            result.put("status", "NEW_USER");
            result.put("recommendation", "Start with basics: Math, Programming fundamentals");
            return result;
        }

        // 1. Overall average score
        double avgScore = activities.stream()
                .mapToInt(UserLearningActivity::getScore)
                .average()
                .orElse(0);

        // 2. GROUP BY TOPIC (IMPORTANT FIX)
        Map<String, List<Integer>> topicScores = new HashMap<>();

        for (UserLearningActivity a : activities) {
            topicScores
                    .computeIfAbsent(a.getTopic(), k -> new ArrayList<>())
                    .add(a.getScore());
        }

        // 3. Find weakest topic using AVERAGE per topic
        String weakestTopic = topicScores.entrySet()
        .stream()
        .min(Comparator.comparingDouble(entry -> {
            List<Integer> scores = entry.getValue();

            double avg = scores.stream()
                    .mapToInt(i -> i)
                    .average()
                    .orElse(0);

            int lastScore = scores.get(scores.size() - 1);

            // combine avg + recent performance
            return avg + (100 - lastScore) * 0.1;
        }))
        .map(Map.Entry::getKey)
        .orElse("General");

        // 4. Determine level
        String level;
        String nextStep;

        if (avgScore < 50) {
            level = "BEGINNER";
            nextStep = "Review basics of " + weakestTopic;
        } else if (avgScore < 75) {
            level = "INTERMEDIATE";
            nextStep = "Practice exercises in " + weakestTopic;
        } else {
            level = "ADVANCED";
            nextStep = "Try advanced challenges in " + weakestTopic;
        }

        // 5. Trend detection
        boolean improving = false;

        if (activities.size() >= 2) {
            int last = activities.get(activities.size() - 1).getScore();
            int previous = activities.get(activities.size() - 2).getScore();
            improving = last > previous;
        }

        // 6. Response
        result.put("averageScore", avgScore);
        result.put("userLevel", level);
        result.put("weakestTopic", weakestTopic);
        result.put("nextStep", nextStep);
        result.put("isImproving", improving);

        return result;
    }
}