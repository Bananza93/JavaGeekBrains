package ru.geekbrains.algo_and_data_struct.lesson4;

public class TelegramTask3 {
    public static int findPrimeNumber(int serialNumber) {
        int count = 1;
        int currNumber = 2;
        while (count < serialNumber) {
            if (isPrime(++currNumber)) count++;
        }
        return currNumber;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(number); i += 6){
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
