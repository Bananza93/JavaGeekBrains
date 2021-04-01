package ru.geekbrains.java_level_1.lesson7;

public class Bowl {

    private final int capacity;
    private int currentFoodAmount;
    private int numberOfRefills = 1;

    public Bowl(int capacity) {
        this.capacity = capacity;
        this.currentFoodAmount = 0;
    }

    public void fillBowl(int amount) {
        int freeSpace = this.capacity - currentFoodAmount;
        if (amount > freeSpace) {
            System.out.print(amount + " еды это перебор! ");
            amount = freeSpace;
        }
        currentFoodAmount += amount;
        System.out.println("В миску добавлено " + amount + " еды. Текущее количество: " + currentFoodAmount);
    }

    public boolean emptyBowl(int amount) {
        if (currentFoodAmount < amount) {
            System.out.println("В миске столько нет! Пробую найти добавку...");
            if (!isAbleToRefillBowl()) {
                return false;
            }
        }
        currentFoodAmount -= amount;
        return true;
    }

    public boolean isAbleToRefillBowl() {
        if (numberOfRefills > 0) {
            System.out.println("Добавка найдена! Заполняю миску...");
            this.fillBowl(capacity - currentFoodAmount);
            numberOfRefills--;
            return true;
        }
        System.out.println("Добавка не найдена. Извините, мистер кот!");
        return false;
    }
}
