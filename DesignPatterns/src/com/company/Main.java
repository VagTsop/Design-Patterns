package com.company;

import com.company.models.TaskManager;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();
        taskManager.run();
    }

}
