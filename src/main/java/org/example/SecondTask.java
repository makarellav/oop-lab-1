package org.example;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SecondTask extends Task {
    // Declare instance variables for matrices A, B, and C, and other necessary variables
    private double[][] matrixA;
    private double[][] matrixB;
    private double[][] matrixC;
    private double start;
    private double end;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void describe() {
        // Calculate and print modulo values based on student number
        var c5 = StudentInfo.STUDENT_NUMBER % 5;
        System.out.println(STR."C5 = \{c5}");

        var c7 = StudentInfo.STUDENT_NUMBER % 7;
        System.out.println(STR."C7 = \{c7}");

        var c11 = StudentInfo.STUDENT_NUMBER % 11;
        System.out.println(STR."C11 = \{c11}");

        // Print information about the task and matrices
        System.out.println("C = A x B");
        System.out.println("Тип елементів матриці - double");
        System.out.println("Дія з матрицею C - обчислити суму найбільших елементів кожного рядка матриці");
    }

    // Method to set the dimensions for matrix A
    private void setMatrixA(int rows, int cols) {
        matrixA = new double[rows][cols];
    }

    // Method to set the dimensions for matrix B
    private void setMatrixB(int rows, int cols) {
        matrixB = new double[rows][cols];
    }

    // Method to set matrix C with the result of matrix multiplication
    private void setMatrixC(double[][] multiplicationResult) {
        matrixC = multiplicationResult;
    }

    @Override
    public String getSummary() {
        return "Виконати дії з матрицями";
    }

    @Override
    public void readData() {
        // Use a loop to ensure valid input
        var inputValid = false;

        while (!inputValid) {
            try {
                // Prompt the user to input values for matrix A and B dimensions
                System.out.println("Введіть кількість рядків матриці A: ");
                var matrixARows = scanner.nextInt();

                // Validate input for matrix A rows
                if (matrixARows < 1) {
                    System.out.println(Errors.getMatrixRowsError());
                    System.out.println();

                    continue;
                }

                System.out.println("Введіть кількість стовпців матриці A: ");
                var matrixACols = scanner.nextInt();

                // Validate input for matrix A columns
                if (matrixACols < 1) {
                    System.out.println(Errors.getMatrixColsError());
                    System.out.println();

                    continue;
                }

                // Set dimensions for matrix A
                setMatrixA(matrixARows, matrixACols);
                System.out.println("Матрицю A успішно створено!");
                System.out.println();

                // Prompt the user to input values for matrix B dimensions
                System.out.println("Введіть кількість рядків матриці B: ");
                var matrixBRows = scanner.nextInt();

                // Validate input for matrix B rows
                if (matrixBRows < 1) {
                    System.out.println(Errors.getMatrixRowsError());
                    System.out.println();

                    continue;
                }

                // Validate the possibility of matrix multiplication
                if (matrixACols != matrixBRows) {
                    System.out.println("Помилка (неможливо перемножити матриці): кількість стовпців матриці A != кількості рядків матриці B");
                    System.out.println();

                    continue;
                }

                // Prompt the user to input values for matrix B columns
                System.out.println("Введіть кількість стовпців матриці B: ");
                var matrixBCols = scanner.nextInt();

                // Validate input for matrix B columns
                if (matrixBCols < 1) {
                    System.out.println(Errors.getMatrixColsError());
                    System.out.println();

                    continue;
                }

                // Set dimensions for matrix B
                setMatrixB(matrixBRows, matrixBCols);
                System.out.println("Матрицю B успішно створено!");
                System.out.println();

                // Prompt the user to input the range for generating random numbers for matrices
                System.out.println("Введіть значення для початку діапазону, в якому будуть згенеровані числа для матриць: ");
                start = scanner.nextDouble();

                System.out.println("Введіть значення для кінця діапазону, в якому будуть згенеровані числа для матриць: ");
                end = scanner.nextDouble();

                // Validate the range input
                if (end <= start) {
                    System.out.println("Помилка: початок діапазону має бути меншим за кінець");

                    continue;
                }

                System.out.println();

                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println(Errors.getOutOfRangeError());
            } finally {
                // Consume the newline character to avoid infinite loop
                scanner.nextLine();
            }
        }
    }

    // Method to initialize a matrix with random double values within a given range
    private void initMatrix(@NotNull double[][] matrix) {
        var rand = new Random();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (end - start) * rand.nextDouble() + start;
            }
        }
    }

    private void printMatrix(@NotNull double[][] matrix, String matrixName) {
        System.out.println(STR."Матриця \{matrixName}:");
        System.out.println("[");
        for (double[] row : matrix) {
            System.out.println(STR."\t\{Arrays.toString(row)}");
        }
        System.out.println("]");
        System.out.println();
    }

    @NotNull
    private double[][] multiplyMatrices(@NotNull double[][] matrixA, @NotNull double[][] matrixB) {
        var result = new double[matrixA.length][matrixB[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                double sum = 0;

                for (int i = 0; i < matrixB.length; i++) {
                    sum += matrixA[row][i] * matrixB[i][col];
                }

                result[row][col] = sum;
            }
        }

        return result;
    }

    // Method to calculate the sum of the maximum elements in each row of a matrix
    @Contract(pure = true)
    private double calculateResult(@NotNull double[][] resultMatrix) {
        double result = 0;

        for (double[] row : resultMatrix) {
            double max = row[0];

            for (double el : row) {
                if (el > max) {
                    max = el;
                }
            }

            result += max;
        }

        return result;
    }

    // Method to solve the task
    public void solve() {
        // Initialize matrices A and B with random values
        initMatrix(matrixA);
        initMatrix(matrixB);

        // Multiply matrices A and B, set the result to matrix C
        var resultMatrix = multiplyMatrices(matrixA, matrixB);

        setMatrixC(resultMatrix);

        // Print matrices A, B, and C
        printMatrix(matrixA, "A");
        printMatrix(matrixB, "B");
        printMatrix(matrixC, "C");

        // Calculate and print the sum of the maximum elements in each row of matrix C
        var result = calculateResult(matrixC);

        System.out.println(STR."Сума найбільших елементів кожного рядка матриці С: \{result}");
        System.out.println();
    }
}
