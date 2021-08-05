package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TelegramTask1 {

    private static char[] sourceString;
    private static Set<String> result;

    public static String[] getAllCombinations(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str is null");
        }
        sourceString = str.toCharArray();
        result = new TreeSet<>();

        for (int i = sourceString.length - 1; i >= 0; i--) {
            result.add(String.valueOf(sourceString));
            manipulate(Arrays.copyOf(sourceString, sourceString.length), 1);
            swap(sourceString, 0, i);
        }


        //result.add(str);
        /*for (int i = 0; i < sourceString.length; i++) {
            for (int j = 0; j < sourceString.length - 1; j++) {
                if (sourceString[j] == sourceString[sourceString.length - 1]) continue;
                swap(j, sourceString.length - 1);
                result.add(String.valueOf(sourceString));
            }
        }*/
        return result.toArray(new String[0]);
    }

    private static void manipulate(char[] arr, int startIndex) {
        for (int i = 0; i < arr.length - startIndex; i++) {
            manipulate(arr, startIndex + 1);
            swap(arr, startIndex, arr.length - 1);
            result.add(String.valueOf(arr));
            if (arr.length - startIndex == 2) break;
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
