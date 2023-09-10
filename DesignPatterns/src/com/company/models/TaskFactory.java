package com.company.models;

public class TaskFactory {
    public static Task createTask(String taskType, String title) {
        if ("work".equalsIgnoreCase(taskType)) {
            return new WorkTask(title, taskType);
        } else if ("personal".equalsIgnoreCase(taskType)) {
            return new PersonalTask(title, taskType);
        } else {
            throw new IllegalArgumentException("Invalid task type");
        }
    }
}