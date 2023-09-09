package com.company.models;

import com.company.interfaces.Observer;

public class TaskCompletionNotifier implements Observer<Task> {
    @Override
    public void update(Task task) {
        if (task.isCompleted()) {
            System.out.println("Task completed: " + task.getTitle());
        }
    }
}