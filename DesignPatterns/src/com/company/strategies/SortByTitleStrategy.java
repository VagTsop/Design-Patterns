package com.company.strategies;

import com.company.interfaces.TaskSortingStrategy;
import com.company.models.Task;

import java.util.Comparator;
import java.util.List;

// Concrete sorting strategy: Sort tasks by title
public class SortByTitleStrategy implements TaskSortingStrategy {
    @Override
    public void sortTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getTitle));
    }
}