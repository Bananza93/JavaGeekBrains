package ru.geekbrains.algo_and_data_struct.lesson3;

public interface Queue<E> {

    boolean add(E value);

    E remove();

    E peek();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
