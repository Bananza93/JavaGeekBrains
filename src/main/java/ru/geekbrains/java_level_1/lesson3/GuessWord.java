package ru.geekbrains.java_level_1.lesson3;

/*
 * 2. Создать массив из слов
 *    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
 *                      "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
 *    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
 *    правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
 *    apple – загаданное
 *    apricot - ответ игрока
 *    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 *    Для сравнения двух слов посимвольно можно пользоваться:
 *    String str = "apple";
 *    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
 *    Играем до тех пор, пока игрок не отгадает слово.
 *    Используем только маленькие буквы.
 * */

import java.util.Random;
import java.util.Scanner;

public class GuessWord {

    private static final Scanner  playerAnswer = new Scanner(System.in);
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
            "pumpkin", "potato"};

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        System.out.println("Добро пожаловать в игру \"Угадай слово\"!");
        gameplay();
    }

    private static void gameplay() {
        StringBuilder sb = new StringBuilder("###############");
        String guessedWord = words[new Random().nextInt(words.length)];
        String answer;
        while (true) {
            System.out.print("Введите слово: ");
            answer = playerAnswer.next().toLowerCase();
            if (!answer.equals(guessedWord)) {
                for (int i = 0; i < guessedWord.length() && i < answer.length(); i++) {
                    if (answer.charAt(i) == guessedWord.charAt(i) && sb.charAt(i) != answer.charAt(i)) {
                        sb.replace(i, i + 1, Character.toString(answer.charAt(i)));
                    }
                }
                System.out.println("Буквы на своих местах: " + sb.toString());
            } else {
                System.out.println("Вы победили! Загаданное слово: " + guessedWord);
                break;
            }
        }
    }
}