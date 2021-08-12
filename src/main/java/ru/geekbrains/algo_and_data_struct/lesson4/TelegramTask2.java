package ru.geekbrains.algo_and_data_struct.lesson4;

public class TelegramTask2 {
    public static int getMinNumber(int numberOfWays) {
        if (numberOfWays < 1) throw new IllegalArgumentException("numberOfWays must be >= 1");
        int currNumber = 4;
        int currWays = 1;
        while (currWays < numberOfWays) {
            currNumber++;
            currWays = calculate(currNumber);
        }
        return currNumber;
    }

    private static int calculate(int number) {
        int ways = 0;
        int currSubtractNumber = 2;
        while (currSubtractNumber < number) {
            if (isPrime(currSubtractNumber)) {
                ways += calculate(number - currSubtractNumber, currSubtractNumber);
            }
            currSubtractNumber++;
        }
        return ways;
    }

    private static int calculate(int number, int threshold) {
        int ways = 0;
        int currSubtractNumber = 2;
        while (currSubtractNumber <= number && currSubtractNumber <= threshold) {
            if (isPrime(currSubtractNumber)) {
                if (number == currSubtractNumber) ways++;
                else ways += calculate(number - currSubtractNumber, currSubtractNumber);
            }
            currSubtractNumber++;
        }
        return ways;
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
