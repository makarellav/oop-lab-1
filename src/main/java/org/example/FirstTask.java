package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTask extends Task {
    // Create a Scanner object for user input
    private final Scanner scanner = new Scanner(System.in);

    // Declare instance variables a, b, and n of type byte
    private byte a;
    private byte b;
    private byte n;

    // Method to solve the task
    public void solve() {
        // Initialize a variable to store the sum of calculations
        var sum = 0.0;

        // Nested loops iterating over i and j from a and b to n
        for (byte i = a; i < n; i++) {
            var acc = 0.0;

            for (byte j = b; j < n; j++) {
                // Calculate the denominator, avoid division by zero
                var denominator = (byte) (i + j);

                // Check for division by zero and skip the iteration
                if (denominator == 0) {
                    System.out.println("Ітерацію пропущено: ділення на нуль");

                    continue;
                }

                // Update the sum based on the given formula
                acc += (double) (i - j) / denominator;
            }

            sum += acc;
        }

        // Print the result of the calculation
        System.out.println(STR."Результат обчислення: \{sum}");
        System.out.println();
    }

    @Override
    public void describe() {
        // Calculate and print modulo values based on student number
        var c2 = StudentInfo.STUDENT_NUMBER % 2;
        System.out.println(STR."C2 = \{c2}");

        var c3 = StudentInfo.STUDENT_NUMBER % 3;
        System.out.println(STR."C3 = \{c3}");

        var c5 = StudentInfo.STUDENT_NUMBER % 5;
        System.out.println(STR."C5 = \{c5}");

        var c7 = StudentInfo.STUDENT_NUMBER % 7;
        System.out.println(STR."C7 = \{c7}");

        // Print additional information
        System.out.println("O1 = +");
        System.out.println(STR."C = \{c3}");
        System.out.println("O2 = -");
        System.out.println("Типи i та j = byte");
    }

    @Override
    public String getSummary() {
        return "Обчислити значення функції";
    }

    @Override
    public void readData() {
        // Use a loop to ensure valid input
        var inputValid = false;

        while (!inputValid) {
            try {
                // Prompt the user to input values for a, b, and n
                System.out.println("Введіть значення a (початкове значення i для зовнішнього циклу):");
                a = scanner.nextByte();

                System.out.println("Введіть значення b (початкове значення j для внутрішнього циклу):");
                b = scanner.nextByte();

                System.out.println("Введіть значення n (фінальне значення i та j):");
                n = scanner.nextByte();

                // Set inputValid to true if input is successful
                inputValid = true;
            } catch (InputMismatchException e) {
                // Handle input mismatch exception and prompt the user again
                System.out.println(Errors.getOutOfRangeError("byte"));
                System.out.println();
            } finally {
                // Consume the newline character to avoid infinite loop
                scanner.nextLine();
            }
        }
    }
}
