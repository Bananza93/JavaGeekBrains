package ru.geekbrains.algo_and_data_struct.lesson2;

import java.util.Arrays;

public class Lesson2_HW {
    public static void main(String[] args) {
        Notebook[] arr1 = Notebook.getNotebooksArray(5000);
        Notebook[] arr2 = Arrays.copyOf(arr1, arr1.length);
        //For unsorted array
        long start = System.currentTimeMillis();
        Arrays.sort(arr1);
        System.out.println("Arrays sort: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        QuickSort.sort(arr2);
        System.out.println("Quicksort: " + (System.currentTimeMillis() - start));
        System.out.println("----------------------------------------");
        //Sort validation
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                System.out.println("MISMATCH (" + i + "):");
                System.out.println(arr1[i]);
                System.out.println(arr2[i]);
                System.out.println();
            }
        }
        //For sorted array
        start = System.currentTimeMillis();
        Arrays.sort(arr1);
        System.out.println("Arrays sort: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        QuickSort.sort(arr2);
        System.out.println("Quicksort: " + (System.currentTimeMillis() - start));
    }
}
