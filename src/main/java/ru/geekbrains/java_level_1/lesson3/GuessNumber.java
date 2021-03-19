package ru.geekbrains.java_level_1.lesson3;

/*
 * 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
 *    При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
 *    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 * */

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private static final Scanner playerAnswer = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        int isPlay;
        System.out.println("Добро пожаловать в игру \"Угадай число\"!");
        do {
            System.out.println("\nВам необходимо угадать число от 0 до 9. У вас 3 попытки.");
            gameplay();
            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет: ");
            isPlay = playerAnswer.nextInt();
        } while (isPlay != 0);
    }

    private static void gameplay() {
        int guessedNumber = new Random().nextInt(10);
        for (int i = 1; i <= 3; i++) {
            System.out.print("(Попытка " + i + ") Введите число: ");
            int answer = playerAnswer.nextInt();
            if (answer == guessedNumber) {
                System.out.println("Вы победили!");
                return;
            } else if (i != 3) {
                if (answer < guessedNumber) {
                    System.out.println("Загаданное число больше");
                } else {
                    System.out.println("Загаданное число меньше");
                }
            }
        }
        System.out.println("Вы проиграли. Загаданное число: " + guessedNumber);
    }
}