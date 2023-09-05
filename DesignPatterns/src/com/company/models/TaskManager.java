package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static TaskManager instance; // Singleton instance

    private List<Task> tasks;

    private Scanner scanner;

    private TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    private void addTask() {
        System.out.print("Enter task type (work/personal): ");
        String taskType = scanner.nextLine();
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        Task task = TaskFactory.createTask(taskType, title);

        TaskCompletionNotifier notifier = new TaskCompletionNotifier();

        task.addObserver(notifier);

        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void markTaskCompleted() {
        listTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private void deleteTask() {
        listTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task '" + removedTask.getTitle() + "' deleted.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }

    }


    public void run() {
        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
