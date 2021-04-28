package ru.geekbrains.java_level_2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private static final Map<String, ArrayList<String>> book = new HashMap<>();

    private Phonebook() {}

    public static void add(String surname, String phoneNumber) {
        String normSurname = normalizeSurname(surname);
        ArrayList<String> currPhoneList = book.getOrDefault(normSurname, new ArrayList<>());
        currPhoneList.add(phoneNumber);
        book.put(normSurname, currPhoneList);
    }

    public static void get(String surname) {
        String normSurname = normalizeSurname(surname);
        System.out.println(normSurname);
        if (book.containsKey(normSurname)) {
            book.get(normSurname).forEach(System.out::println);
        } else {
            System.out.println("Номеров не найдено.");
        }
    }

    private static String normalizeSurname(String sourceSurname) {
        return sourceSurname.substring(0, 1).toUpperCase() + sourceSurname.substring(1).toLowerCase();
    }
}
