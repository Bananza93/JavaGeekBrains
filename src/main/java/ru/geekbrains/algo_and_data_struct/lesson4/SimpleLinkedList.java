package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Iterator;

public interface SimpleLinkedList<E> extends Iterable<E> {
    boolean add(E element);
    E remove();
    boolean remove(E element);
    int size();
    boolean isEmpty();
    void display();
    Iterator<E> iterator();

    class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
