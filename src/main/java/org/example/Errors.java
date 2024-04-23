package org.example;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Errors {
    public static String getOutOfRangeError(String type) {
        return STR."Помилка: значення поза діапазоном '\{type}'";
    }

    @NotNull
    @Contract(pure = true)
    public static String getOutOfRangeError() {
        return "Помилка: значення поза діапазоном.";
    }

    @NotNull
    @Contract(pure = true)
    public static String getMatrixRowsError() {
        return "Помилка: невірне значення для кількості рядків матриці";
    }

    @NotNull
    @Contract(pure = true)
    public static String getMatrixColsError() {
        return "Помилка: невірне значення для кількості стовпців матриці";
    }
}
