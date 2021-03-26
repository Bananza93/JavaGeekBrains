package ru.geekbrains.java_level_1.lesson5;

/*
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class Lesson5Homework {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan Ivanov", "Engineer", "ivanivanov@companyname.com", "89275553322", 50000, 28);
        employees[1] = new Employee("Petr Petrov", "Lead Engineer", "petrpetrov@companyname.com", "89275554433", 100000, 42);
        employees[2] = new Employee("Sergey Sergeyev", "Accountant", "sergeysergeyev@companyname.com", "89275555544", 60000, 32);
        employees[3] = new Employee("Alexey Ananasov", "Courier", "ananasovalexey@companyname.com", "89275557766", 35000, 23);
        employees[4] = new Employee("Boris Zakharov", "Janitor", "zakharovboris@companyname.com", "89275558877", 25000, 52);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printEmployee();
            }
        }
    }
}
