package ru.geekbrains.algo_and_data_struct.lesson4;

import java.io.File;
import java.util.Arrays;

public class Lesson4_HW {
    public static void main(String[] args) {
        task1();
        task2();
        telegramTask1();
        telegramTask2();
        telegramTask3();
        telegramTask4();
    }

    private static void task1() {
        SimpleLinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer i : list) System.out.print(i + " ");
        System.out.println();
        list.remove();
        list.display();
        list.remove(4);
        list.display();
        list.remove(2);
        for (Integer i : list) System.out.print(i + " ");
        System.out.println("\n");
    }

    private static void task2() {
        Deque<Integer> deque = new DequeLinkedList<>();
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.display();
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());
        System.out.println("Removed: " + deque.removeFirst());
        System.out.println("Removed: " + deque.removeLast());
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());
        for (Integer i : deque) System.out.print(i + " ");
        System.out.println("\n");
    }

    private static void telegramTask1() {
        String[] strings = {"", "a", "aa", "abba", "abcd"};
        for (String string : strings) {
            String[] t = TelegramTask1.getAllCombinations(string);
            System.out.print("String \"" + string + "\" -> ");
            System.out.println(Arrays.toString(t));
        }
        System.out.println();
    }

    private static void telegramTask2() {
        for (int i = 1; i <= 50; i+=5) {
            int ij = TelegramTask2.getMinNumber(i);
            if (ij != -1) System.out.println("Для " + i + " способов минимальное число " + ij);
        }
        System.out.println("Для " + 5000 + " способов минимальное число " + TelegramTask2.getMinNumber(5000) + "\n");
    }

    private static void telegramTask3() {
        long start = System.currentTimeMillis();
        System.out.println("Первые 100 простых чисел:");
        for (int i = 1; i <= 100; i++) {
            System.out.print(TelegramTask3.findPrimeNumber(i) + " ");
        }
        System.out.println();
        System.out.println("100001 простое число = " + TelegramTask3.findPrimeNumber(100001) + " (за " + (System.currentTimeMillis() - start) + " ms)");
    }

    private static void telegramTask4() {
        long start = System.currentTimeMillis();
        TelegramTask4.calculateRating(new File("C:\\voina_i_mir_tom_1.txt"));
        System.out.println("\nTime = " + (System.currentTimeMillis() - start) + " ms");
    }
}
