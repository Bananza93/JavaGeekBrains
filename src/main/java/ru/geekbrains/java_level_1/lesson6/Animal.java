package ru.geekbrains.java_level_1.lesson6;

public abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    private static int animalCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit)
            System.out.println(name + " пробежал " + distance + " м.");
        else
            System.out.println(name + " столько не пробежит!");
    }

    public void swim(int distance) {
        if (distance <= swimLimit)
            System.out.println(name + " проплыл " + distance + " м.");
        else
            System.out.println(name + " столько не проплывет!");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}