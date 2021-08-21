package ru.geekbrains.algo_and_data_struct.lesson8;

public class Lesson8_HW {
    public static void main(String[] args) {
        HashTableImpl<String, Integer> map = new HashTableImpl<>();
        for (int i = 0; i < 24; i++) {
            map.put("String_" + i, i);
        }
        System.out.println(map.remove("String_20"));
        System.out.println(map.remove("String_18"));
        System.out.println(map.remove("String_1"));
        System.out.println(map.get("String_1"));
        System.out.println(map.get("String_15"));
        System.out.println(map.get("String_5"));
        System.out.println(map.containsKey("String_5"));
        System.out.println(map.containsKey("String_222"));
        System.out.println(map.containsKey(null));
        System.out.println(map.containsValue(29));
        System.out.println(map.containsValue(3));
        System.out.println(map.containsValue(222));
        map.display();
    }
}