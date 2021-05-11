package ru.geekbrains.java_level_2.lesson5;

import java.util.Arrays;

public class Lesson5Homework {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr1 = new float[size];
        Arrays.fill(arr1, 1.0f);
        singleThreadCompute(arr1);

        float[] arr2 = new float[size];
        Arrays.fill(arr2, 1.0f);
        twoThreadsCompute(arr2);

        System.out.println("Массивы arr1 и arr2 " + (Arrays.equals(arr1,arr2) ? "равны." : "не равны."));
    }

    public static void singleThreadCompute(float[] arr) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("SINGLE THREAD: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    public static void twoThreadsCompute(float[] arr) throws InterruptedException {
        float[] tempArr1 = new float[h];
        float[] tempArr2 = new float[h];

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr,0,tempArr1,0,h);
        System.arraycopy(arr,h,tempArr2,0,h);

        Thread r1 = new Thread(() -> {
            for (int i = 0; i < tempArr1.length; i++) {
                tempArr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread r2 = new Thread(() -> {
            for (int i = h; i < arr.length; i++) {
                tempArr2[i - h] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        r1.start();
        r2.start();
        r1.join();
        r2.join();

        System.arraycopy(tempArr1,0,arr,0,h);
        System.arraycopy(tempArr2,0,arr,h,h);

        System.out.println("TWO THREADS: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
