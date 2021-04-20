package ru.geekbrains.java_level_2.lesson1;

public class Robot implements Participant {

    String name;
    int distanceLimit;
    int heightLimit;

    public Robot(String name, int distanceLimit, int heightLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.heightLimit = heightLimit;
    }

    public String getTypeAndName() {
        return "Робот " + name;
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
