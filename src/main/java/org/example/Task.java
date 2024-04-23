package org.example;

// Define an abstract class named org.example.Task, serving as a blueprint for specific tasks
public abstract class Task {
    // Method to print information about the task based on its number
    public void printInfo(int taskNumber) {
        System.out.println("-".repeat(Utils.REPEAT_COUNT));
        System.out.println(STR."ЗАВДАННЯ \{taskNumber}");
        // Call the describe method to provide detailed information about the task
        describe();
        System.out.println("-".repeat(Utils.REPEAT_COUNT));

    }

    // Abstract method to describe the details of the task, to be implemented by subclasses
    public abstract void describe();

    // Abstract method to retrieve a summary of the task, to be implemented by subclasses
    public abstract String getSummary();

    // Abstract method representing the main logic of solving the task, to be implemented by subclasses
    public abstract void solve();

    // Abstract method to read necessary data for the task, to be implemented by subclasses
    public abstract void readData();
}
