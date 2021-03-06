package ru.geekbrains.algo_and_data_struct.lesson3;

public interface Deque<E> extends Queue<E> {

    boolean addFirst(E value);

    boolean addLast(E value);

    E removeFirst();

    E removeLast();

    E peekFirst();

    E peekLast();
}
