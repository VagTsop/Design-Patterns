package com.company.commands;

import com.company.interfaces.Command;
import com.company.models.TaskManager;

public class AddTaskCommand implements Command {
    private TaskManager taskManager;

    public AddTaskCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        taskManager.getAddTask();
    }
}
