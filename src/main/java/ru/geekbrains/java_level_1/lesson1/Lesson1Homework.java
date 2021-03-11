package ru.geekbrains.java_level_1.lesson1;

/**
 * 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
 * 2. Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
 * 3. Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
 * Результат работы метода вывести в консоль
 * 4. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
 * 5. Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 * Для проверки работы вывести результаты работы метода в консоль
 * */

public class Lesson1Homework {
    public static void main(String[] args) {

        System.out.println("Задача 1");
        System.out.println(calculateExpression(10, 50, 10, 3));

        System.out.println("\nЗадача 2");
        System.out.println(checkSum(5,14));
        System.out.println(checkSum(10,21));

        System.out.println("\nЗадача 3");
        checkPosOrNeg(10);
        checkPosOrNeg(0);
        checkPosOrNeg(-10);

        System.out.println("\nЗадача 4");
        System.out.println(getGreeting("Сергей"));

        System.out.println("\nЗадача 5");
        System.out.println(checkLeapYear(1800));
        System.out.println(checkLeapYear(2000));
        System.out.println(checkLeapYear(2004));

    }

    private static float calculateExpression(int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    private static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void checkPosOrNeg(int a) {
        if (a < 0) System.out.println("Число " + a + " отрицательное");
        else System.out.println("Число " + a + " положительное");
    }

    private static String getGreeting(String name) {
        return "Привет, " + name + "!";
    }

    private static String checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return "Год " + year + " високосный";
        } else {
            return "Год " + year + " невисокосный";
        }
    }
}