package ru.geekbrains.java_level_1.lesson6;

/**
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 * 4. * Добавить подсчет созданных котов, собак и животных.
 */

public class Lesson6Homework {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Murzik", 150, 0),
                new Cat("Barsik", 300, 0),
                new Dog("Bobik", 600, 50),
                new Dog("Sharik", 200, 20)
        };

        System.out.println("Всего создано " + Animal.getAnimalCount() + " животных.");
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());

        for (Animal animal : animals) {
            animal.run(250);
            animal.swim(25);
        }
    }
}