package com.company.commands;

import com.company.interfaces.Command;
import com.company.models.TaskManager;

public class MarkTaskCompletedCommand implements Command {
    private TaskManager taskManager;

    public MarkTaskCompletedCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        taskManager.getMarkTaskAsCompleted();
    }
}
