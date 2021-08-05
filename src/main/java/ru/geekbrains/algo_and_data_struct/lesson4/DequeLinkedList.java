package ru.geekbrains.algo_and_data_struct.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeLinkedList<E> implements Deque<E>, Iterable<E> {

    private Node<E> firstNode = null;
    private Node<E> lastNode = null;
    private int size;

    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            lastNode = firstNode = new Node<>(element, lastNode, firstNode);
        } else {
            Node<E> currentFirst = firstNode;
            firstNode = new Node<>(element, null, currentFirst);
            currentFirst.setPrevious(firstNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (isEmpty()) {
            lastNode = firstNode = new Node<>(element, lastNode, firstNode);
        } else {
            Node<E> currentLast = lastNode;
            lastNode = new Node<E>(element, currentLast, null);
            currentLast.setNext(lastNode);
        }
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> removed = firstNode;
        firstNode = removed.getNext();
        firstNode.setPrevious(null);
        size--;
        return removed.getData();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        Node<E> removed = lastNode;
        lastNode = removed.getPrevious();
        lastNode.setNext(null);
        size--;
        return removed.getData();
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return firstNode.getData();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return lastNode.getData();
    }

    @Override
    public boolean add(E element) {
        return addFirst(element);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException();
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
        return new DequeLinkedListIterator();
    }

    private class DequeLinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> next;
        private int nextIndex;

        DequeLinkedListIterator() {
            next = DequeLinkedList.this.firstNode;
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
