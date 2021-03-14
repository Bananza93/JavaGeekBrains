package ru.geekbrains.java_level_1.lesson2;

public class Lesson2Homework {

    public static void main(String[] args) {
        System.out.println("Задача 1");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        reverseElements(arr1);
        printArray(arr1);
        System.out.println();

        System.out.println("Задача 2");
        int[] arr2 = new int[8];
        fillArray(arr2);
        printArray(arr2);
        System.out.println();

        System.out.println("Задача 3");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        boostLessThan6Values(arr3);
        printArray(arr3);
        System.out.println();

        System.out.println("Задача 4");
        int[][] arr4 = new int[5][5];
        fillDiagonally(arr4);
        print2DArray(arr4);
        System.out.println();

        System.out.println("Задача 5");
        int[] arr5 = {5, 3, 8, 1, 7, 2, 9, 6, 4};
        findMinAndMaxElements(arr5);
        System.out.println();

        System.out.println("Задача 6");
        int[] arr61 = {2, 2, 2, 1, 2, 2, 10, 1};    //{2, 2, 2, 1, 2, 2, || 10, 1} -> true
        int[] arr62 = {1, 1, 1, 2, 1};              //{1, 1, 1, || 2, 1} -> true
        int[] arr63 = {1, 1, 9, 2, 1, 3};           //{1, 1, 9, 2, 1, 3} -> false
        System.out.println(checkBalance(arr61));
        System.out.println(checkBalance(arr62));
        System.out.println(checkBalance(arr63));
        System.out.println();

        System.out.println("Задача 7");
        int[] arr7 = {1, 2, 3, 4, 5};
        shiftValues(arr7, -2);
        printArray(arr7);
    }

    /*
    * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    *    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    * */
    private static void reverseElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    /*
    * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    * */
    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

    /*
    * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    * */
    private static void boostLessThan6Values(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
    }

    /*
    * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    *    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    * */
    private static void fillDiagonally(int[][] array) {
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            array[i][i] = 1;
            array[i][j] = 1;
        }
    }

    /*
    * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    * */
    private static void findMinAndMaxElements(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }

    /*
    * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    *    если в массиве есть место, в котором сумма левой и правой части массива равны.
    *    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    *    граница показана символами ||, эти символы в массив не входят.
    * */
    private static boolean checkBalance(int[] array) {
        int sum = 0;
        for (int i : array) sum += i;

        for (int i = 0, tempSum = 0; i < array.length - 1; i++) {
            tempSum += array[i];
            if (tempSum == sum - tempSum) return true;
        }
        return false;
    }

    /*
    * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    *    при этом метод должен сместить все элементы массива на n позиций.
    *    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    *    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    *    При каком n в какую сторону сдвиг можете выбирать сами.
    * */
    private static void shiftValues(int[] array, int shiftLength) {
        if (shiftLength >= 0) {
            for (int i = 0; i < shiftLength; i++) {
                for (int nextIndex = 1, bufferIndex = 0; nextIndex < array.length; nextIndex++) {
                    swapValues(array, nextIndex, bufferIndex);
                }
            }
        } else {
            for (int i = 0; i > shiftLength; i--) {
                for (int nextIndex = array.length - 2, bufferIndex = array.length - 1; nextIndex >= 0; nextIndex--) {
                    swapValues(array, nextIndex, bufferIndex);
                }
            }
        }
    }

    private static void swapValues(int[] array, int nextIndex, int bufferIndex) {
        int storedValue = array[nextIndex];
        array[nextIndex] = array[bufferIndex];
        array[bufferIndex] = storedValue;
    }

    private static void print2DArray(int[][] array2D) {
        for (int[] arr : array2D) {
            printArray(arr);
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
