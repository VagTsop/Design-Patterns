package com.company.strategies;

import com.company.interfaces.TaskSortingStrategy;
import com.company.models.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Concrete sorting strategy: Sort tasks by type (work/personal)
public class SortByTypeStrategy implements TaskSortingStrategy {
    @Override
    public void sortTasks(List<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                // Compare tasks by type (work/personal)
                return task1.getType().compareTo(task2.getType());
            }
        });
    }
}