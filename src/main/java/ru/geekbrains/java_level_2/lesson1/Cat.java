package ru.geekbrains.java_level_2.lesson1;

public class Cat implements Participant {

    String name;
    int distanceLimit;
    int heightLimit;

    public Cat(String name, int distanceLimit, int heightLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.heightLimit = heightLimit;
    }

    public String getTypeAndName() {
        return "Кот " + name;
    }

    @Override
    public int getDistanceLimit() {
        return distanceLimit;
    }

    @Override
    public int getHeightLimit() {
        return heightLimit;
    }
}
