package ru.geekbrains.java_level_3.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lesson6HomeworkTest {
    private Lesson6Homework instance;

    @BeforeEach
    void beforeEach() {
        System.out.println("Start");
        instance = new Lesson6Homework();
    }

    @AfterEach
    void afterEach() {
        System.out.println("Complete");
    }

    @Test
    void lastAfterLastFour() {
        int[] arr1 = {1,2,4,4,2,3,4,1,7};
        int[] result1 = {1,7};
        Assertions.assertArrayEquals(result1, instance.lastAfterLastFour(arr1));
        int[] arr2 = {};
        Assertions.assertThrows(RuntimeException.class, () -> instance.lastAfterLastFour(arr2));
        int[] arr3 = {1,2,4,4,2,3,4,1,4};
        int[] result3 = {};
        Assertions.assertArrayEquals(result3, instance.lastAfterLastFour(arr3));
        int[] arr4 = {1,2,3,5,2,3,0,1,7};
        Assertions.assertThrows(RuntimeException.class, () -> instance.lastAfterLastFour(arr4));
    }

    @Test
    void isOneAndFourOnly() {
        int[] arr1 = {1,4,1,1,4,4,4,1,1};
        Assertions.assertTrue(instance.isOneAndFourOnly(arr1));
        int[] arr2 = {1,1,1,1,1,1};
        Assertions.assertFalse(instance.isOneAndFourOnly(arr2));
        int[] arr3 = {4,4,4,4,4,4};
        Assertions.assertFalse(instance.isOneAndFourOnly(arr3));
        int[] arr4 = {1,1,1,4,4,1,1,3,1,4};
        Assertions.assertThrows(RuntimeException.class, () -> instance.isOneAndFourOnly(arr4));
    }
}