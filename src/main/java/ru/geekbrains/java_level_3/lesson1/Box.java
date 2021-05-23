package ru.geekbrains.java_level_3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruitBox;

    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public float getWeight() {
        int size = fruitBox.size();
        if (size == 0) return 0.0f;
        else return fruitBox.get(0).fruitWeight() * size;
    }

    public void addFruitToBox(T fruit) {
        fruitBox.add(fruit);
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void shiftFruitsTo(Box<T> anotherBox) {
        if (this == anotherBox) return;
        for (T fruit : fruitBox) {
            anotherBox.addFruitToBox(fruit);
        }
        this.fruitBox.clear();
    }
}
