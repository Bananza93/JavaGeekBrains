package ru.geekbrains.java_level_2.lesson1;

public class Human implements Participant {

    String name;
    int distanceLimit;
    int heightLimit;

    public Human(String name, int distanceLimit, int heightLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.heightLimit = heightLimit;
    }

    public String getTypeAndName() {
        return "Человек " + name;
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
