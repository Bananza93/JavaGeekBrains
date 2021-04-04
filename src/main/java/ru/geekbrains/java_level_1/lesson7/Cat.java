package ru.geekbrains.java_level_1.lesson7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eatFood(Bowl bowl) {
        System.out.println("Кот " + name + " пытается съесть из миски " + appetite + " еды...");
        if (!bowl.emptyBowl(appetite)) {
            System.out.println("Кот " + name + " не простит подобного отношения. Проверяйте ботинки перед надеванием!");
        } else {
            System.out.println("Кот " + name + " наелся и пошел по своим делам.");
            isFull = true;
        }
    }

    public boolean isHungry() {
        return !this.isFull;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Кот " + name + " (аппетит = " + appetite + ")";
    }
}
