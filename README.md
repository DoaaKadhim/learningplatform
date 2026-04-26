# 📚 Learning Behavior Analytics Backend API

## 🧠 Overview

The Learning Behavior Analytics Backend API is a Spring Boot application designed to track, analyze, and interpret user learning activities.

Instead of treating learning as static scores or course completion, this system models it as a continuous stream of behavioral data. Each activity contributes to understanding user performance trends over time.

The system also generates **adaptive learning insights** using rule-based intelligence, simulating an AI-style recommendation engine.

---

## 💡 Core Concept

Traditional learning systems store static academic results.

This system treats learning as **behavioral analytics data**, where each interaction provides insights into:

- Performance progression
- Weak subject areas
- Learning efficiency
- Personalized recommendations

Each record includes:

- User ID
- Topic
- Score
- Time spent

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Web (REST APIs)
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

---

## 🏗️ System Architecture

The system follows a layered architecture:

- **Controller Layer** → Handles REST API requests
- **Service Layer** → Contains business logic and analytics processing
- **Repository Layer** → Manages database operations using JPA
- **Model Layer** → Defines entity structure

---

## 📊 Data Model

### UserLearningActivity

```json id="mdl001"
{
  "id": 1,
  "userId": "u1",
  "topic": "Math",
  "score": 90,
  "timeSpent": 40
}