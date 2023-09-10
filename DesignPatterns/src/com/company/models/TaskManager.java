// TaskManager.java (Complete code)
package com.company.models;

import com.company.commands.AddTaskCommand;
import com.company.commands.DeleteTaskCommand;
import com.company.commands.ListTasksCommand;
import com.company.commands.MarkTaskCompletedCommand;
import com.company.decorators.DueDateTaskDecorator;
import com.company.decorators.PriorityTaskDecorator;
import com.company.enums.Priority;
import com.company.interfaces.Command;
import com.company.interfaces.TaskSortingStrategy;
import com.company.strategies.SortByTitleStrategy;
import com.company.strategies.SortByTypeStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static TaskManager instance;
    private TaskSortingStrategy sortingStrategy;
    private List<Task> tasks;
    private Scanner scanner;

    private TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        sortingStrategy = new SortByTitleStrategy();
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


        task = new DueDateTaskDecorator(task,LocalDate.now());
        task = new PriorityTaskDecorator(task, Priority.HIGH);

        task.addObserver(notifier);
        tasks.add(task);
        System.out.println(task.getDescription()); // This should include priority and due date
        System.out.println("Task added successfully!");
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public void setSortingStrategy(TaskSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortTasks() {
        if (sortingStrategy != null) {
            sortingStrategy.sortTasks(tasks);
            System.out.println("Tasks sorted successfully!");
        } else {
            System.out.println("No sorting strategy set.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            sortingStrategy.sortTasks(tasks);

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
        scanner.nextLine();

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
        scanner.nextLine();

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task '" + removedTask.getTitle() + "' deleted.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public void getAddTask() {
        this.addTask();
    }

    public void getDeleteTask() {
        this.deleteTask();
    }

    public void getMarkTaskAsCompleted() {
        this.markTaskCompleted();
    }

    public void getListTask() {
        this.listTasks();
    }

    public void run() {
        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Set Sorting Strategy");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    executeCommand(new AddTaskCommand(this));
                    break;
                case 2:
                    executeCommand(new ListTasksCommand(this));
                    break;
                case 3:
                    executeCommand(new MarkTaskCompletedCommand(this));
                    break;
                case 4:
                    executeCommand(new DeleteTaskCommand(this));
                    break;
                case 5:
                    System.out.println("Available Sorting Strategies:");
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Type");
                    System.out.print("Select a sorting strategy: ");
                    int strategyChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (strategyChoice) {
                        case 1:
                            setSortingStrategy(new SortByTitleStrategy());
                            System.out.println("Sorting strategy set to SortByTitleStrategy.");
                            break;
                        case 2:
                            setSortingStrategy(new SortByTypeStrategy());
                            System.out.println("Sorting strategy set to SortByTypeStrategy.");
                            break;
                        default:
                            System.out.println("Invalid strategy choice.");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}