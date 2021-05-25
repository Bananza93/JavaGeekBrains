package ru.geekbrains.java_level_3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson1Homework {
    public static void main(String[] args) {
        String[] arr = {"String1", "String2", "String3", "String4", "String5", "String6"};
        System.out.println(Arrays.toString(arr));
        swapElementsIntoArray(arr, 0,5);
        System.out.println(Arrays.toString(arr));
        List<String> list = arrayToArrayList(arr);
        System.out.println(list);



        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 15; i++) {
            appleBox1.addFruitToBox(new Apple());
        }
        for (int i = 0; i < 10; i++) {
            appleBox2.addFruitToBox(new Apple());
        }
        for (int i = 0; i < 10; i++) {
            orangeBox.addFruitToBox(new Orange());
        }
        System.out.println("appleBox1 weight = " + appleBox1.getWeight());
        System.out.println("appleBox1 weight = " + appleBox2.getWeight());
        System.out.println("orangeBox weight = " + orangeBox.getWeight());
        System.out.println("Compare appleBox1 and orangeBox: " + appleBox1.compare(orangeBox));
        System.out.println("Compare appleBox2 and orangeBox: " + appleBox2.compare(orangeBox));
        appleBox1.shiftFruitsTo(appleBox2);
        System.out.println("appleBox1 weight after shifting: " + appleBox1.getWeight());
        System.out.println("appleBox2 weight after shifting: " + appleBox2.getWeight());
    }

    /*1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)*/
    public static <T> void swapElementsIntoArray(T[] arr, int indexA, int indexB) {
        T tmpA = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmpA;
    }

    /*2. Написать метод, который преобразует массив в ArrayList*/
    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return Arrays.stream(array).collect(Collectors.toCollection(ArrayList::new));
    }
}
