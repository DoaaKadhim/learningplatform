# Learning Behavior Analytics Backend API

## 🧠 Project Overview

This project is a backend system built with Java and Spring Boot that captures, stores, and organizes user learning behavior in a structured way.

Instead of treating learning as simple course completion or static grading, this system models learning as a continuous stream of measurable interactions.

Each interaction becomes a data point that can later be analyzed to understand performance trends, learning efficiency, and user progress over time.

The long-term goal of this system is to serve as the foundation for an **adaptive learning analytics engine** capable of supporting personalization and recommendation features.

---

## 💡 Core Concept

Traditional learning systems mainly store static information such as users, courses, and grades.

This system takes a different approach:

> It treats learning as behavioral data rather than static records.

Every learning activity captures:

- The user performing the action
- The topic being studied
- The score achieved
- The time spent on the task

By structuring data this way, the system can later support deeper insights such as:

- Identifying weak topics per user
- Tracking improvement over time
- Measuring learning efficiency
- Supporting adaptive recommendations in future versions

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Web (REST APIs)
- Spring Data JPA
- H2 Database (development)
- Maven

---

## 🏗️ Architecture

The system follows a clean layered architecture:


### Layers Description:

- **Controller Layer** → Handles incoming REST API requests  
- **Service Layer** → Contains business logic  
- **Repository Layer** → Handles database operations using JPA  
- **Model Layer** → Defines data structure for learning activities  

---

## 📊 Data Model Example

```json
{
  "id": 1,
  "userId": "u1",
  "topic": "Math",
  "score": 90,
  "timeSpent": 40
}
