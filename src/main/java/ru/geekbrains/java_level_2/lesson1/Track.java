package ru.geekbrains.java_level_2.lesson1;

public class Track implements Obstacle {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
