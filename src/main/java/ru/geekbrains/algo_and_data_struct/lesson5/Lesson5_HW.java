package ru.geekbrains.algo_and_data_struct.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson5_HW {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        System.out.println(Task1.calculatePower(2, 0));
        System.out.println(Task1.calculatePower(2, 1));
        System.out.println(Task1.calculatePower(2, 2));
        System.out.println(Task1.calculatePower(2, 3));
        System.out.println(Task1.calculatePower(10, 2));
        System.out.println(Task1.calculatePower(10, 3));
        System.out.println(Task1.calculatePower(0, 0));
        System.out.println(Task1.calculatePower(0, 5));
        System.out.println(Task1.calculatePower(1, -2));
        System.out.println(Task1.calculatePower(-1, 6));
        System.out.println(Task1.calculatePower(-1, 7));
        System.out.println(Task1.calculatePower(-2, 2));
        System.out.println(Task1.calculatePower(-3, 3));
        System.out.println(Task1.calculatePower(2, -3));
        System.out.println(Task1.calculatePower(2, -2));
        System.out.println(Task1.calculatePower(10, -3));
        System.out.println(Task1.calculatePower(10, -4));
        System.out.println(Task1.calculatePower(10, -5));
    }

    private static void task2() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Book", 1, 600);
        Item item2 = new Item("Binocular", 2, 5000);
        Item item3 = new Item("Medkit", 4, 1500);
        Item item4 = new Item("Notebook", 2, 40000);
        Item item5 = new Item("Pot", 1, 500);
        Collections.addAll(items, item1, item2, item3, item4, item5);

        List<Item> result;
        for (int i = 0; i <= 10; i++) {
            result = KnapsackProblem.getMaxProfitCombination(items, i);
            System.out.println("При вместимости рюкзака = " + i + " лучшая комбинация: " + result);
        }
    }
}
