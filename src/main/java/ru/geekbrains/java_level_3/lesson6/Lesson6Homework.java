package ru.geekbrains.java_level_3.lesson6;

import java.util.Arrays;

public class Lesson6Homework {

    /**
     * 2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
     * Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public int[] lastAfterLastFour(int[] array) throws RuntimeException {
        int lastIndex = array.length;
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (array[i] == 4) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == array.length) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, lastIndex, array.length);
    }

    /**
     * 3. Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Если в массиве есть числа отличные от 1 и 4, то метод выбрасывает RuntimeException;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public boolean isOneAndFourOnly(int[] array) throws RuntimeException {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int j : array) {
            if (j == 1) hasOne = true;
            else if (j == 4) hasFour = true;
            else throw new RuntimeException();
        }
        return hasOne && hasFour;
    }
}
