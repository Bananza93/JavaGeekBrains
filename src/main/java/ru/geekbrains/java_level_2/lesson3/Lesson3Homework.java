package ru.geekbrains.java_level_2.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Lesson3Homework {
    public static void main(String[] args) {
        ex1();
        System.out.println();
        ex2();
    }

    private static void ex1() {
        //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать сколько раз встречается каждое слово.
        String[] wordArray = {"procedure", "highway", "excitement", "profession",
                "orange", "difference", "procedure", "employee",
                "teaching", "failure", "session", "conversation",
                "ratio", "employee", "writer", "highway",
                "response", "employee", "setting", "procedure"};

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : wordArray) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        System.out.print("Уникальные слова: ");
        System.out.println(String.join(", ", wordMap.keySet()) + "\n");

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.printf("Слово \"%s\" встречается %d раз(-а)\n", entry.getKey(), entry.getValue());
        }
    }

    private static void ex2() {
        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.

        Phonebook.add("Jones", "89998887766");
        Phonebook.add("Sparrow", "89956665544");
        Phonebook.add("JONES", "89915554433");
        Phonebook.add("turner", "89904443322");

        Phonebook.get("jones");
        Phonebook.get("TURNER");
        Phonebook.get("Swann");
    }
}
