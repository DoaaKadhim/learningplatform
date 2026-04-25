package com.learningplatform.repository;

import com.learningplatform.model.UserLearningActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLearningActivityRepository extends JpaRepository<UserLearningActivity, Long> {

    List<UserLearningActivity> findByUserId(String userId);
}