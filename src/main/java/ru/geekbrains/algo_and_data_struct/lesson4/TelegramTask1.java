package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Set;
import java.util.TreeSet;

public class TelegramTask1 {

    private static char[] splitString;
    private static Set<String> result;

    public static String[] getAllCombinations(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str is null");
        }
        splitString = str.toCharArray();
        result = new TreeSet<>();
        manipulate( 0);
        return result.toArray(new String[0]);
    }

    private static void manipulate(int startIndex) {
        for (int i = 0; i < splitString.length - (startIndex); i++) {
            manipulate(startIndex + 1);
            shift(startIndex);
            result.add(String.valueOf(splitString));
        }
    }

    private static void shift(int startIndex) {
        if (splitString.length - (startIndex + 1) > 0) {
            char tmp = splitString[startIndex];
            System.arraycopy(splitString, startIndex + 1, splitString, startIndex, splitString.length - (startIndex + 1));
            splitString[splitString.length - 1] = tmp;
        }
    }
}
