package com.company.decorators;

import com.company.models.Task;

public abstract class TaskDecorator extends Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        super(decoratedTask.getTitle(), decoratedTask.getType());
        this.decoratedTask = decoratedTask;
    }

    @Override
    public String getDescription() {
        return decoratedTask.getDescription(); // Delegate to the decorated task's getDescription()
    }
}