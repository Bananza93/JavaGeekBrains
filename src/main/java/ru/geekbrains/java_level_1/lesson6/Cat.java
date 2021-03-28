package ru.geekbrains.java_level_1.lesson6;

public class Cat extends Animal {
    private static int catCount = 0;

    public Cat(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
}