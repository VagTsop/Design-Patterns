package com.company.commands;

import com.company.interfaces.Command;
import com.company.models.TaskManager;

public class DeleteTaskCommand implements Command {
    private TaskManager taskManager;

    public DeleteTaskCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        taskManager.getDeleteTask();
    }
}
