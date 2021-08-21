package ru.geekbrains.algo_and_data_struct.lesson8;

public interface HashTable<K, V> {
    boolean put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    V remove(K key);

    int size();

    boolean isEmpty();

    void display();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        void setValue(V value);

    }
}