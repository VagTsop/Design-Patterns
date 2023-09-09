package com.company.commands;

import com.company.interfaces.Command;
import com.company.models.TaskManager;

public class ListTasksCommand implements Command {
    private TaskManager taskManager;

    public ListTasksCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void execute() {
        taskManager.getListTask();
    }
}