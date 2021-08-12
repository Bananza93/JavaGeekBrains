package ru.geekbrains.algo_and_data_struct.lesson6;

public interface BinaryTree<E extends Comparable<? super E>> {

    boolean add(E value);
    boolean contains(E value);
    boolean remove(E value);
    int getCurrentDepth();
    boolean isEmpty();
    int size();
    void display();
    boolean isBalanced();
}
