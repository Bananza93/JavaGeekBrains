package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Lesson4_HW {
    public static void main(String[] args) {
        /*SimpleLinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        //list.display();
        list.remove();
        list.display();
        list.remove(4);
        list.display();
        list.remove(2);
        for (Integer i : list) {
            System.out.print(i + " ");
        }*/

        /*Deque<Integer> deque = new DequeLinkedList<>();
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
        deque.display();*/
        long start = System.currentTimeMillis();
        String[] t = TelegramTask1.getAllCombinations("abcde");
        System.out.println(Arrays.toString(t) + " " + (System.currentTimeMillis() - start));
        /*for (int i = 20; i <= 100; i++) {
            int ij = TelegramTask2.getMinNumber(i);
            if (ij != -1) System.out.println("Для " + i + " способов минимальное число " + ij);
        }*/
        //System.out.println(TelegramTask2.getMinNumber(5001));

        /*
        * Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-е простое число - 13.
        * Какое число является 10001-м простым числом?
        * */
//        long start = System.currentTimeMillis();
//        System.out.println(TelegramTask3.findPrimeNumber(100001) + " " + (System.currentTimeMillis() - start));

    }


}
