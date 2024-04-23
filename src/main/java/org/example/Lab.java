package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab {
    private final Scanner scanner = new Scanner(System.in);

    // Create an ArrayList to store org.example.Task objects
    private final ArrayList<Task> tasks = new ArrayList<>();

    // Constructor for the org.example.Lab class, accepts an array of org.example.Task objects
    public Lab(Task... tasks) {
        // Add the org.example.Task objects to the ArrayList
        Collections.addAll(this.tasks, tasks);
    }

    // Method to execute the lab tasks
    public void solve() {
        // Variable to control whether the lab should exit
        var shouldExit = false;

        System.out.println("Вітаю на першій лабі! :)");

        // Continue until the user decides to exit
        while (!shouldExit) {
            System.out.println("Будь ласка оберіть номер завдання, яке хочете вирішити або напишіть 'exit' для виходу:");

            // Iterate through tasks and print their summaries
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(STR."\{i + 1}) \{tasks.get(i).getSummary()}");
            }

            System.out.println("Оберіть опцію: ");
            var input = scanner.nextLine().trim().toLowerCase();

            // Check if the user wants to exit
            if (input.equals("exit")) {
                System.out.println("На все добре ;)");

                shouldExit = true;
            } else {
                try {
                    // Try to parse user input as an integer representing task number
                    var taskNum = Integer.parseInt(input);
                    var taskIndex = taskNum - 1;

                    // Get the selected task and execute its methods
                    var task = tasks.get(taskIndex);

                    task.printInfo(taskNum);
                    task.readData();
                    task.solve();
                } catch (NumberFormatException _) {
                    // Handle invalid input when it is not a number
                    System.out.println("Помилка: некоректний номер завдання");
                } catch (IndexOutOfBoundsException _) {
                    // Handle invalid input when the task number is out of bounds
                    System.out.println("Помилка: не вдалося знайти завдання");
                }
            }
        }
    }
}
