package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements SimpleLinkedList<E>, Iterable<E> {

    protected Node<E> firstNode = null;
    protected int size;

    @Override
    public boolean add(E element) {
        Node<E> currentFirst = firstNode;
        firstNode = new Node<>(element, currentFirst);
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        E currentData = firstNode.getData();
        firstNode = firstNode.getNext();
        size--;
        return currentData;
    }

    @Override
    public boolean remove(E element) {
        if (isEmpty()) return false;
        Node<E> currentNode = firstNode;
        Node<E> previousNode = null;

        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                if (previousNode != null) {
                    previousNode.setNext(currentNode.getNext());
                    size--;
                } else remove();
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
            if (currentNode != null) sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }

    private class SimpleLinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> next;
        private int nextIndex;

        SimpleLinkedListIterator() {
            next = SimpleLinkedListImpl.this.firstNode;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = next;
            next = next.getNext();
            nextIndex++;
            return current.getData();
        }
    }
}
