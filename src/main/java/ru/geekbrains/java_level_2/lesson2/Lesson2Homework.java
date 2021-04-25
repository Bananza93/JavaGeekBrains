package ru.geekbrains.java_level_2.lesson2;

public class Lesson2Homework {
    public static void main(String[] args) {
        String[][] arr = new String[][] {
                new String[] {"1","2","3","4"},
                new String[] {"1","2","3","4"},
                new String[] {"1","2","3","4"},
                new String[] {"1","2","3","4"}
        };

        int sum;
        try {
            sum = countSumInArray4x4(arr);
            System.out.println("Sum = " + sum);
        } catch (MySizeArrayException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int countSumInArray4x4(String[][] array) throws MySizeArrayException, MyArrayDataException {
        if (array.length != 4) throw new MySizeArrayException("Incorrect array length (array.length = " + array.length + ")");
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) throw new MySizeArrayException("Incorrect array length (array[" + i + "].length = " + array[i].length + ")");
        }

        int resultSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int tmp;
                try {
                    tmp = Integer.parseInt(array[i][j]);
                    resultSum += tmp;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("String \"" + array[i][j] + "\" in array[" + i + "][" + j + "] not a number.");
                }
            }
        }
        return resultSum;
    }
}
