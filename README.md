# Task Management Console App

This is a simple console application for managing tasks. It allows users to add tasks, list tasks, mark tasks as completed, and delete tasks. The application utilizes design patterns to maintain a clean and extensible codebase.

## Design Patterns Used

### 1. Singleton Pattern

The `TaskManager` class follows the Singleton pattern, ensuring that only one instance of the `TaskManager` is created throughout the application's lifecycle. This pattern provides a global point of access to the task management functionality.

### 2. Observer Pattern

The Observer pattern is employed to notify observers (in this case, the `TaskCompletionNotifier` class) when a task is marked as completed. This decouples the task and observer classes, allowing for easy extension with new observers in the future.

### 3. Factory Pattern

The `TaskFactory` class uses the Factory pattern to create different types of tasks (work and personal) based on user input. This pattern encapsulates the task creation logic, making it easy to add new task types without modifying existing code.

### 4. Command Pattern

The `Command pattern` is used to encapsulate various user actions (e.g., adding a task, marking a task as completed) into separate command objects. This separation of concerns allows for a more modular and maintainable codebase. Each command class encapsulates the logic of a specific action, promoting code reusability and extensibility.

## Getting Started

To run the application, follow these steps:

1. Clone the repository or download the source code.

2. Compile the Java files using your preferred Java compiler:
   
   ```shell
   javac -d bin -sourcepath src src/com/company/Main.java
   
Navigate to the bin directory:

   ```shell
   cd bin
   ```
Run the application:
   ```shell
java com.company.Main
   ```
## Usage
The application provides the following menu options:

- **Add Task**: Allows you to add a new task. You will be prompted to enter the task type (work/personal) and the task title.

- **List Tasks**: Lists all the tasks that have been added.

- **Mark Task as Completed**: Marks a task as completed. You will be prompted to select a task by its number.

- **Delete Task**: Deletes a task from the list. You will be prompted to select a task by its number.

- **Exit**: Exits the application.

## Extending the Application

The application is designed to be extensible:

- To add new types of tasks, create a new class that extends the Task class and implement the desired functionality. Update the TaskFactory to recognize and create instances of this new task type.

- To add new observers for tasks, create a new class that implements the Observer interface and implement the update method. You can then attach the observer to tasks as needed.

- Additional menu options and features can be added by extending the TaskManager class and updating the menu and switch-case statements in the run method.

## Contributing

Feel free to contribute to the project by opening issues or pull requests on the GitHub repository.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

Thank you for using this Task Management Console App. If you have any questions or suggestions, please feel free to reach out. Enjoy managing your tasks efficiently!
