package com.learningplatform.service;

import com.learningplatform.model.UserLearningActivity;
import com.learningplatform.repository.UserLearningActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningService {

    private final UserLearningActivityRepository repository;

    public LearningService(UserLearningActivityRepository repository) {
        this.repository = repository;
    }

    public UserLearningActivity saveActivity(UserLearningActivity activity) {
        return repository.save(activity);
    }

    public List<UserLearningActivity> getUserActivities(String userId) {
        return repository.findByUserId(userId);
    }
}