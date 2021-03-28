package ru.geekbrains.java_level_1.lesson6;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}