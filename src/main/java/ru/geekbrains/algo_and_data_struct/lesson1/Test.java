package ru.geekbrains.algo_and_data_struct.lesson1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {
    private static long iter = 0;
    private static long factIter = 0;
    private static long fibIter = 0;

    public static void main(String[] args) {
        long start = System.nanoTime();
//        System.out.println(getSimpleDividers1(600851475143L));
//        System.out.println("Time = " + ((double) (System.nanoTime() - start) / 1000000000));
//        start = System.nanoTime();
//        System.out.println(Arrays.deepToString(fillArrayBySpiralMethod(2,3)));
/*        int[][] arr = fillArrayBySpiralMethod(3, 1);
        for (int[] arr1 : arr) {
            for (int i : arr1) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }*/

        String a = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
//        String b = "123456789123456789123456789123451234567891234567891234567891234512345678912345678912345678912345";
//        String a = "123";
        String b = "3211";
        String res = addBigNumber(a,b);
        BigInteger resB = new BigInteger(a).add(new BigInteger(b));
        System.out.println(res + "\n" + resB);
        System.out.println(res.equals(resB.toString()));
//        System.out.println(getSimpleDividers2(1092));
//        System.out.println("Time = " + ((double) (System.nanoTime() - start) / 1000000000));
//        testA();
//        System.out.println("After test A: " + iter);
//        iter = 0;
//        testB();
//        System.out.println("After test B: " + iter);
//        iter = 0;
//        testC();
//        System.out.println("After test C: " + iter);
//        long start = System.currentTimeMillis();
//        factorial(BigInteger.valueOf(5000));
//        System.out.println("Iter = " + factIter + " | Time = " + ((double)(System.currentTimeMillis() - start) / 1000));
//        start = System.currentTimeMillis();
//        fib(BigInteger.valueOf(41));
//        System.out.println("Iter = " + fibIter + " | Time = " + ((double)(System.currentTimeMillis() - start) / 1000));
    }

    private static void testC() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                iter++;
                arrayList.add(i * j);
                n--;
            }
        }
    }

    private static void testB() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                iter++;
                arrayList.add(i * j);
            }
        }
    }

    public static void testA() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                iter++;
                arrayList.add(i * j);
            }
        }
    }

    public static BigInteger factorial(BigInteger n) {
        factIter++;
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }

    public static BigInteger fib(BigInteger n) {
        fibIter++;
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }

    public static Long getSimpleDividers1(long number) {
        long maxThreshold = number / 2;
        for (int i = 2; i < maxThreshold; i++) {
            if ((double) number % i == 0) {
                long currDivider = number / i;
                for (int j = 2; j < currDivider / 2; j++) {
                    if (currDivider % j == 0) {
                        currDivider = -1;
                        break;
                    }
                }
                if (currDivider != -1) return currDivider;
            }
        }
        return -1L;
    }

    private static Long getSimpleDividers2(long number) {
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
