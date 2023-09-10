package com.company.decorators;

import com.company.models.Task;

import java.time.LocalDate;

public class DueDateTaskDecorator extends TaskDecorator {
    private LocalDate dueDate;

    public DueDateTaskDecorator(Task decoratedTask, LocalDate dueDate) {
        super(decoratedTask);
        this.dueDate = dueDate;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " [Due Date: " + dueDate + "]";
    }
}
