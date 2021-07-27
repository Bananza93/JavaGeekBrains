package ru.geekbrains.algo_and_data_struct.lesson3;

import java.util.Arrays;

public class Lesson3_HW {

    public static void main(String[] args) {
        findMissingNumberTest();
    }

    private static int findMissingNumber(int[] array) {
        if (array.length == 0) return 1;

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (lastIndex - firstIndex > 0) {
            int mid = (firstIndex + lastIndex) / 2;
            if (array[mid] == mid + 1) {
                firstIndex = mid + 1;
            } else if (mid > 0 && lastIndex - firstIndex != 1) {
                lastIndex = mid - 1;
            } else {
                lastIndex = mid;
            }
        }

        if (array[firstIndex] - firstIndex == 2) return array[firstIndex] - 1;
        else return array[firstIndex] + 1;
    }

    private static void findMissingNumberTest() {
        //Empty array test
        System.out.println(findMissingNumber(new int[0]));
        //One element array
        System.out.println(findMissingNumber(new int[] {1}));
        System.out.println(findMissingNumber(new int[] {2}));
        //Other tests
        for (int size = 2; size <= 20; size++) {
            int[] array = new int[size];
            int skipNumber = (int) (Math.random() * (size + 1)) + 1;
            for (int number = 1, index = 0; index < size; number++) {
                if (number == skipNumber) continue;
                array[index] = number;
                index++;
            }
            int result = findMissingNumber(array);
            System.out.println(Arrays.toString(array));
            System.out.println("Skip number = " + skipNumber);
            System.out.println("Result      = " + result);
            System.out.println();
        }
    }
}
