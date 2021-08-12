package ru.geekbrains.algo_and_data_struct.lesson5;

public class Task1 {
    public static double calculatePower(int base, int exponent) {
        if (base == 0) {
            if (exponent > 0) return 0;
            if (exponent < 0) throw new IllegalArgumentException("For base = 0 exponent must be >= 0");
        }
        if (exponent == 0 || base == 1) return 1;
        if (base == -1) return exponent % 2 == 0 ? 1 : -1;
        return calculatePower1(exponent > 0 ? base : 1 / (double) base, Math.abs(exponent));
    }

    private static double calculatePower1(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent % 2 == 1) {
            return base * calculatePower1(base, exponent - 1);
        } else {
            double b = calculatePower1(base, exponent / 2);
            return b * b;
        }
    }
}
