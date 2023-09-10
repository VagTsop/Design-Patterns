package com.company.decorators;

import com.company.enums.Priority;
import com.company.models.Task;

public class PriorityTaskDecorator extends TaskDecorator {
    private Priority priority;

    public PriorityTaskDecorator(Task decoratedTask, Priority priority) {
        super(decoratedTask);
        this.priority = priority;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " [Priority: " + priority + "]";
    }

}