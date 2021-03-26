package ru.geekbrains.java_level_1.lesson5;

/*
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Name: " + fullName
                + ", age: " + age
                + ", position: " + position
                + ", salary: " + salary
                + ", phone: " + phoneNumber
                + ", e-mail: " + email;
    }
}
