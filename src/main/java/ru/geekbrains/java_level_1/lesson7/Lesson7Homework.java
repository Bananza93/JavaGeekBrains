package ru.geekbrains.java_level_1.lesson7;

public class Lesson7Homework {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 10),
                new Cat("Sobaka", 18),
                new Cat("YaTebeNeKot", 9)
        };

        for (Cat cat : cats) {
            System.out.println(cat + " создан");
        }

        Bowl bowl = new Bowl(26);
        bowl.fillBowl(30);

        System.out.println();

        for (Cat cat : cats) {
            cat.eatFood(bowl);
            System.out.println();
        }

        for (Cat cat : cats) {
            if(cat.isHungry()) {
                System.out.println("Кот " + cat.getName() + " голоден.");
            } else {
                System.out.println("Кот " + cat.getName() + " сыт.");
            }
        }
    }
}
