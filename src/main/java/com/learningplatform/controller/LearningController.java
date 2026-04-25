package com.learningplatform.controller;

import com.learningplatform.model.UserLearningActivity;
import com.learningplatform.service.LearningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learning")
public class LearningController {

    private final LearningService service;

    public LearningController(LearningService service) {
        this.service = service;
    }

    // 1. Save learning activity
    @PostMapping("/activity")
    public UserLearningActivity addActivity(@RequestBody UserLearningActivity activity) {
        return service.saveActivity(activity);
    }

    // 2. Get all activities of a user
    @GetMapping("/user/{userId}")
    public List<UserLearningActivity> getUserActivities(@PathVariable String userId) {
        return service.getUserActivities(userId);
    }
}