package ru.geekbrains.algo_and_data_struct.lesson4;

public interface Deque<E> extends SimpleLinkedList<E> {
    boolean addFirst(E element);
    boolean addLast(E element);
    E removeFirst();
    E removeLast();
    E peekFirst();
    E peekLast();
}
