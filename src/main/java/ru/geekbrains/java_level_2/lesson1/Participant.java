package ru.geekbrains.java_level_2.lesson1;

public interface Participant extends Runnable, Jumpable {

    String getTypeAndName();
    int getHeightLimit();
    int getDistanceLimit();

    @Override
    default boolean jump(int height) {
        if (height <= getHeightLimit()) {
            System.out.println(getTypeAndName() + " перепрыгивает стену высотой " + height + " м.");
            return true;
        }
        System.out.println(getTypeAndName() + " не перепрыгивает стену высотой " + height + " м.");
        return false;
    }

    @Override
    default boolean run(int distance) {
        if (distance <= getDistanceLimit()) {
            System.out.println(getTypeAndName() + " пробегает дистанцию " + distance + " м.");
            return true;
        }
        System.out.println(getTypeAndName() + " не пробегает дистанцию " + distance + " м.");
        return false;
    }
}
