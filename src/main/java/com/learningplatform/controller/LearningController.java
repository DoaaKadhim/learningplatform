package com.learningplatform.controller;

import java.util.List;
import java.util.Map;

import com.learningplatform.model.UserLearningActivity;
import com.learningplatform.service.LearningService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/learning")
public class LearningController {

    private final LearningService service;

    public LearningController(LearningService service) {
        this.service = service;
    }

    // Save activity
   @PostMapping("/activities")
   public List<UserLearningActivity> addActivities(@RequestBody List<UserLearningActivity> activities) {
        return activities.stream()
            .map(service::saveActivity)
            .toList();
    }

    // Analytics
    @GetMapping("/analytics/user/{userId}")
    public Map<String, Object> getAnalytics(@PathVariable String userId) {
        return service.getAnalytics(userId);
    }

    // AI Recommendation
    @GetMapping("/recommendation/user/{userId}")
    public Map<String, Object> getRecommendation(@PathVariable String userId) {
        return service.getRecommendation(userId);
    }

}