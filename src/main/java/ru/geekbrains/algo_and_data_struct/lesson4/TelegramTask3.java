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

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6){
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
