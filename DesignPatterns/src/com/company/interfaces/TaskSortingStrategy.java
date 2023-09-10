package com.company.interfaces;

import com.company.models.Task;

import java.util.List;

// TaskSortingStrategy interface for sorting tasks
public interface TaskSortingStrategy {
    void sortTasks(List<Task> tasks);
}