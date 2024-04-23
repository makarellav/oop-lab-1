package org.example;

import java.util.Scanner;

public class ThirdTask extends Task {
    // Define constants for the initial parts of the sentences
    private final String x1 = "Де мало слів, праці і добра";
    private final String x2 = "там";
    private final String x3 = "більше правди";

    // Combine the constants to form the first sentence
    private final String firstSentence = STR."\{x1} \{x2} \{x3}";

    // Declare an instance variable for the second sentence
    private String secondSentence;
    private final Scanner scanner = new Scanner(System.in);

    // Method to process and print the result of the first part of the task
    private void solveFirst() {
        // Define a string to be deleted from the first sentence
        var toDelete = "праці і добра";

        // Find the index of the string to be deleted and create a new sentence without it
        var indexToDelete = firstSentence.indexOf(STR." \{toDelete}");
        var newSentence = STR."\{firstSentence.substring(0, indexToDelete)} \{x2} \{x3}";

        // Print the new sentence without the specified string
        System.out.println(STR."Нове речення без '\{toDelete}': \{newSentence}");

        // Change the string to be deleted to "слів" and remove it from the new sentence
        toDelete = "слів";
        var result = newSentence.replace(STR." \{toDelete}", "");

        // Print the final result without the second specified string
        System.out.println(STR."Результат без '\{toDelete}': \{result}");
        System.out.println();
    }

    // Method to process and print the result of the second part of the task
    private void solveSecond() {
        // Replace all occurrences of 'е' with 'і' in the second sentence
        var result = secondSentence.replace("е", "і");

        // Print the new sentence with replaced characters
        System.out.println(STR."Нове речення з заміненою 'e': \{result}");
        System.out.println();
    }

    // Method to solve the overall task
    public void solve() {
        solveFirst();
        solveSecond();
    }

    @Override
    public void describe() {
        // Print information about the task and its components
        System.out.println("1)");
        System.out.println(STR."\tX1 = \{x1}");
        System.out.println(STR."\tX2 = \{x2}");
        System.out.println(STR."\tX3 = \{x3}");
        System.out.println("\tПобудувати речення - 'Де мало слів, там більше правди.'. Видалити із речення слово - 'слів'.");

        System.out.println("2)");
        System.out.println("\tДля введеного з клавіатури речення всі букви «е» замінити на букви «і»");
    }

    @Override
    public String getSummary() {
        return "Опрацювати текстові данні";
    }

    @Override
    public void readData() {
        // Prompt the user to input a sentence for the second part of the task
        System.out.println("Введіть речення, в якому 'e' буде замінено на 'i':");
        secondSentence = scanner.nextLine();
        System.out.println();
    }
}
