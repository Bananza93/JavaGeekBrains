package ru.geekbrains.algo_and_data_struct.lesson1;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    private static void ex1() {
        System.out.println("Ex. 1");
        long number = 600851475143L;
        long start = System.currentTimeMillis();
        long divider = getMaxPrimeDivider(number);
        long end = System.currentTimeMillis();
        System.out.println("For " + number + " max prime divider is " + divider + ". Time = " + (end - start) + " ms.");
        System.out.println();
    }

    private static void ex2() {
        System.out.println("Ex. 2");
        print2DArray(fillArrayBySpiralMethod(3, 1));
        System.out.println();
        print2DArray(fillArrayBySpiralMethod(2, 3));
        System.out.println();
        print2DArray(fillArrayBySpiralMethod(4, 4));
        System.out.println();
    }

    private static void ex3() {
        System.out.println("Ex. 3");
        String a = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        String b = "123456789123456789123456789123451234567891234567891234567891234512345678912345678912345678912345";
        String c = "123";
        String d = "3211";
        addAndCheckBigNumbers(a, b);
        addAndCheckBigNumbers(a, c);
        addAndCheckBigNumbers(c, d);
        addAndCheckBigNumbers(d, b);
    }

    private static void addAndCheckBigNumbers(String a, String b) {
        String res = addBigNumber(a, b);
        BigInteger resBI = new BigInteger(a).add(new BigInteger(b));
        System.out.println(res + "\n" + resBI);
        System.out.println(res.equals(resBI.toString()));
        System.out.println();
    }

    private static void print2DArray(int[][] arr) {
        for (int[] arr1 : arr) {
            for (int i : arr1) System.out.print(i + "  ");
            System.out.println();
        }
    }

    private static Long getMaxPrimeDivider(long number) {
        long d = 2;
        while (d * d <= number) {
            if (number % d == 0) number /= d;
            else d += 1;
        }
        if (number > 1) return number;
        else return d;
    }

    private static int[][] fillArrayBySpiralMethod(int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height must be positive integer numbers");
        int[][] result = new int[height][width];
        int currH = 0, currW = 0;
        boolean horizDir = true, posDir = true;
        for (int i = 1, size = height * width; i <= size; ) {
            if (result[currH][currW] == 0) {
                result[currH][currW] = i++;
            }
            if (horizDir) {
                int nextW = posDir ? currW + 1 : currW - 1;
                if (nextW < 0 || nextW >= width || result[currH][nextW] != 0) {
                    horizDir = false;
                } else currW = nextW;
            } else {
                int nextH = posDir ? currH + 1 : currH - 1;
                if (nextH < 0 || nextH >= height || result[nextH][currW] != 0) {
                    horizDir = true;
                    posDir = !posDir;
                } else currH = nextH;
            }
        }
        return result;
    }

    private static String addBigNumber(String a, String b) {
        StringBuilder result = new StringBuilder();
        int maxDigits = 18;
        boolean hasExcessDigit = false;
        for (int endA = a.length(), endB = b.length(); endA > 0 || endB > 0; endA-=maxDigits, endB-=maxDigits) {
            String tmpA = a.substring(Math.max(endA - maxDigits, 0), Math.max(endA, 0));
            String tmpB = b.substring(Math.max(endB - maxDigits, 0), Math.max(endB, 0));
            if (tmpA.length() == 0) {
                if (hasExcessDigit) tmpA = "0";
                else {
                    result.insert(0, b.substring(0, endB));
                    break;
                }
            } else if (tmpB.length() == 0) {
                if (hasExcessDigit) tmpB = "0";
                else {
                    result.insert(0, a.substring(0, endA));
                    break;
                }
            }
            String tmpRes = String.valueOf(Long.parseLong(tmpA) + Long.parseLong(tmpB) + (hasExcessDigit ? 1 : 0));
            hasExcessDigit = tmpRes.length() > maxDigits;
            result.insert(0, tmpRes.substring(hasExcessDigit ? 1 : 0));
        }
        return result.toString();
    }
}
