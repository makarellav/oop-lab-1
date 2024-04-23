package org.example;

public class Main {
    public static void main(String[] args) {
        var firstTask = new FirstTask();
        var secondTask = new SecondTask();
        var thirdTask = new ThirdTask();

        var lab = new Lab(firstTask, secondTask, thirdTask);

        lab.solve();
    }
}
