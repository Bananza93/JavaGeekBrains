package ru.geekbrains.algo_and_data_struct.lesson4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelegramTask4 {
    private static final Pattern pattern = Pattern.compile("([a-zA-Zа-яА-Я]+[’-]?+)+");

    public static void calculateRating(File fromFile) {
        Map<String, Integer> words = new HashMap<>();
        Map<Character, Integer> letters = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fromFile, Charset.forName("windows-1251")))) {
            String nextString;
            while ((nextString = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(nextString);
                while (matcher.find()) {
                    String word = matcher.group();
                    words.put(word, words.getOrDefault(word, 0) + 1);
                    char[] wordLetters = word.toCharArray();
                    for (char letter : wordLetters) {
                        if (Character.isAlphabetic(letter)) {
                            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TOP 10 WORDS:");
        words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).forEach(System.out::println);
        System.out.println("\nTOP 10 LETTERS:");
        letters.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).forEach(System.out::println);
    }
}
